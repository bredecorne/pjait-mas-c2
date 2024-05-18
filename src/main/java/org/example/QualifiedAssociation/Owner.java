package org.example.QualifiedAssociation;

import java.util.HashMap;
import java.util.Map;

public class Owner {
    private String name;
    private final Map<String, Hotel> hotels = new HashMap<>();

    public Owner(String name) {
        this.name = name;
    }
    
    public void addHotel(String abbreviation, Hotel hotel) {
        if (hotels.containsKey(abbreviation)) { throw new IllegalArgumentException(); }
        hotels.put(abbreviation, hotel);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
