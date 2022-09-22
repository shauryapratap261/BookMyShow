package models;

import java.util.ArrayList;
import java.util.List;

public class Theatre {
    String name;
    List<Show>shows;
    List<Screen>screens;

    public Theatre(String name, List<Show>shows, List<Screen>screens) {
        this.name = name;
        this.shows = shows;
        this.screens = screens;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Show> getShows() {
        return shows;
    }

    public void setShows(List<Show> shows) {
        this.shows = shows;
    }

    public List<Screen> getScreens() {
        return screens;
    }

    public void setScreens(List<Screen> screens) {
        this.screens = screens;
    }
}
