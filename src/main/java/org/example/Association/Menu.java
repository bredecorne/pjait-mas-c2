package org.example.Association;

import java.util.HashSet;
import java.util.Set;

public class Menu {
    private String name;
    private String description;
    private final Set<Hotel> hotels = new HashSet<>();

    public Menu(String name, String description) {
        this.name = name;
        this.description = description;
    }
    
    public void addHotel(Hotel hotel) {
        if (!hotels.contains(hotel)) {
            hotels.add(hotel);
            hotel.addMenu(this);
        }
    }
    
    public void removeHotel(Hotel hotel) {
        if (hotels.contains(hotel)) {
            hotels.remove(hotel);
            hotel.removeMenu(this);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Hotel> getHotels() {
        return new HashSet<>(hotels);
    }
}
