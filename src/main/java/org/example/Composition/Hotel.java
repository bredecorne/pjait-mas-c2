package org.example.Composition;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Hotel {
    private String name;
    private final String abbreviation; 
    private final List<Room> rooms = new ArrayList<>();
    private final Set<Integer> roomNumbers = new HashSet<>();

    public Hotel(String name, String abbreviation) {
        this.name = name;
        this.abbreviation = abbreviation;
    }

    /**
     * Initializes a new Room object and creates a part-whole association (composition), where part is a Room
     * and whole is an associated Hotel object.
     *
     * @param number the number that corresponds to the Room
     */
    public void addRoom(int number) {
        rooms.add(new Room(number));
    }

    /**
     * Removes a Room object.
     * 
     * @param number the number that corresponds to the Room
     */
    public void removeRoom(int number) {
        rooms.removeIf(r -> r.getNumber() == number);
    }

    public class Room {
        private int number;

        private Room(int number) {
            if (validateNumber(number)) { throw new IllegalArgumentException(); }
            roomNumbers.add(number);
            this.number = number;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            if (validateNumber(number)) { throw new IllegalArgumentException(); }
            roomNumbers.add(number);
            roomNumbers.remove(this.number);
            this.number = number;
        }
        
        public Hotel getHotel() {
            return Hotel.this;
        }

        /**
         * Validates if provided Room number is already in use and if its value is possible (that is the value may
         * not be less or equal than 0).
         * 
         * @param number the number that corresponds to the Room
         * @return boolean value that is true if the provided number is an invalid argument
         */
        private boolean validateNumber(int number) {
            return (number <= 0 || roomNumbers.contains(number));
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

    public List<Room> getRooms() {
        return rooms;
    }
}
