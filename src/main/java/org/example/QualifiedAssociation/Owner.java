package org.example.QualifiedAssociation;

import java.util.HashMap;
import java.util.Map;

public class Owner {
    private String name;
    private final Map<String, Hotel> hotels = new HashMap<>();

    public Owner(String name) {
        this.name = name;
    }

    /**
     * Adds a hotel to the owner's collection, associated with an abbreviation 
     * if the abbreviation is not occupied or blank.
     *
     * @param hotel the Hotel object to add
     */
    public void addHotel(Hotel hotel) {
        if (!(hotels.containsKey(hotel.getAbbreviation()) || hotel.getAbbreviation().isBlank())) {
            hotels.put(hotel.getAbbreviation(), hotel);
            hotel.addOwner(this);
        }
    }
    
    public void removeHotel(String abbreviation) {
        if (hotels.containsKey(abbreviation)) {
            hotels.get(abbreviation).removeOwner(this);
            hotels.remove(abbreviation);
        }
    }
    
    public void removeHotel(Hotel hotel) {
        removeHotel(hotel.getAbbreviation());
    }

    /**
     * Retrieves a hotel associated with the given abbreviation.
     *
     * @param abbreviation the abbreviation of the hotel to find
     * @return the Hotel object, or null if not found
     */
    public Hotel findHotel(String abbreviation) {
        return hotels.get(abbreviation);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Hotel> getHotels() {
        return new HashMap<>(hotels);
    }
}
