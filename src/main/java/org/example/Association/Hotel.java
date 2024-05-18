package org.example.Association;

import java.util.HashSet;
import java.util.Set;

public class Hotel {
    private String name;
    private final String abbreviation;
    private final Set<Menu> menus = new HashSet<>();

    public Hotel(String name, String abbreviation) {
        this.name = name;
        this.abbreviation = abbreviation;
    }
    
    public void addMenu(Menu menu) {
        if (!menus.contains(menu)) {
            menus.add(menu);
            menu.addHotel(this);
        }
    }
    
    public void removeMenu(Menu menu) {
        if (menus.contains(menu)) {
            menus.remove(menu);
            menu.removeHotel(this);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public Set<Menu> getMenus() {
        return new HashSet<>(menus);
    }
}