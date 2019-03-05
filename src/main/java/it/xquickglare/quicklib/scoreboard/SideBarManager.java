package it.xquickglare.quicklib.scoreboard;

import it.xquickglare.quicklib.scoreboard.playerlist.PlayerList;
import it.xquickglare.quicklib.scoreboard.playerprefix.PlayerPrefix;
import it.xquickglare.quicklib.scoreboard.sidebar.SideBar;
import it.xquickglare.quicklib.scoreboard.sidebar.SideBarLine;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.scoreboard.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SideBarManager {

    public static Plugin plugin;
    @Getter
    private final SideBar sideBar;
    @Getter
    private final ScoreboardManager scoreboardManager = Bukkit.getScoreboardManager();
    @Getter
    private final Scoreboard scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
    @Getter
    private final Objective objective = scoreboard.registerNewObjective("QL-SB", "dummy");
    private List<Team> teamList = new ArrayList<>();
    private List<BukkitTask> tasks = new ArrayList<>();

    public SideBarManager(SideBar sideBar) {
        this.sideBar = sideBar;
    }

    public void startUpdates() {
        int[] nameMaxUpdates = new int[1];
        nameMaxUpdates[0] = sideBar.getDisplayName().getStrings().size();
        BukkitTask task = new BukkitRunnable() {
            int updates;
            @Override
            public void run() {
                updates++;
                objective.setDisplayName(sideBar.getDisplayName().getStrings().get(updates));
                if (updates == nameMaxUpdates[0]) {
                    updates = 0;
                }
            }
        }.runTaskTimerAsynchronously(plugin, 0, sideBar.getDisplayName().getUpdateDelay());
        tasks.add(task);
        List<SideBarLine> sideBarLines = sideBar.getSideBarLines();
        for (int i = 0, sideBarLinesSize = sideBarLines.size(); i < sideBarLinesSize; i++) {
            int[] maxUpdates = new int[1];
            SideBarLine sideBarLine = sideBarLines.get(i);
            maxUpdates[0] = sideBarLine.getStrings().size();
            BukkitTask lineTask =new BukkitRunnable() { //TODO> Fix this update method (crate a unique entry creator and update using the team suffix). -MikyPro
                int updates;
                @Override
                public void run() {
                    updates++;
                    teamList.get(updates).getEntries().remove(updates-1);
                    teamList.get(updates).getEntries().add(sideBarLine.getStrings().get(updates));
                    if (updates == maxUpdates[0]) {
                        updates = 0;
                    }
                }
            }.runTaskTimerAsynchronously(plugin, 0, sideBarLine.getUpdateDelay());
            tasks.add(lineTask);
        }
    }

    public void build() {
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        objective.setDisplayName(sideBar.getDisplayName().getStrings().get(0));
        Team[] teams = new Team[(sideBar.getSideBarLines().size() > 15) ? 15 : sideBar.getSideBarLines().size()];
        for (int i = 0, teamsLength = teams.length; i < teamsLength; i++) {
            Team team = teams[i];
            team = scoreboard.registerNewTeam(UUID.randomUUID().toString());
            team.addEntry(sideBar.getSideBarLines().get(i).getStrings().get(0));
            team.setPrefix("");
            team.setSuffix("");
            teamList.add(team);
            objective.getScore(sideBar.getSideBarLines().get(i).getStrings().get(0)).setScore(i);
        }
    }

    public void destroy() {
        tasks.forEach(bukkitTask -> bukkitTask.cancel());

        for (Player player : Bukkit.getOnlinePlayers()) {
            if (player.getScoreboard().getObjectives().contains(objective)) {
                player.getScoreboard().getObjectives().remove(objective);
            }
        }

        for (Objective scoreboardObjective : scoreboard.getObjectives()) {
            scoreboardObjective.unregister();
        }
    }
}
