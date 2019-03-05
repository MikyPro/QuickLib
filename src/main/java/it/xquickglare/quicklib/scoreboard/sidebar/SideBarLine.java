package it.xquickglare.quicklib.scoreboard.sidebar;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class SideBarLine {

    @Getter
    private long updateDelay;
    @Getter
    private List<String> strings = new ArrayList<>();

    public SideBarLine(long updateDelay, String... strings) {
        this.updateDelay = updateDelay;
        for (String string : strings) {
            this.strings.add(string);
        }
    }

    public SideBarLine(long updateDelay, List<String> strings) {
        this.updateDelay = updateDelay;
        this.strings = strings;
    }
}
