package it.xquickglare.quicklib.scoreboard.sidebar;

import lombok.Getter;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.List;

public class SideBar {

    @Getter
    private SideBarLine displayName;
    @Getter
    private List<SideBarLine> sideBarLines = new ArrayList<>();

    public SideBar(SideBarLine displayName, SideBarLine... sideBarLines) {
        this.displayName = displayName;
        for (SideBarLine sideBarLine : sideBarLines) {
            this.sideBarLines.add(sideBarLine);
        }
    }
}
