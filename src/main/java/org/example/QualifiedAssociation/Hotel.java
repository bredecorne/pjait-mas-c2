package org.example.QualifiedAssociation;

import java.util.HashSet;
import java.util.Set;

public class Hotel {
    private String name;
    private final String abbreviation;
    private final Set<Owner> owners = new HashSet<>();
    
    public Hotel(String name, String abbreviation) {
        if (abbreviation.isBlank()) throw new IllegalArgumentException();
        this.name = name;
        this.abbreviation = abbreviation;
    }

    public void addOwner(Owner owner) {
        if (!(owners.contains(owner) || owner == null)) {
            owners.add(owner);
            owner.addHotel(this);
        }
    }
    
    public void removeOwner(Owner owner) {
        if (owners.contains(owner)) {
            owners.remove(owner);
            owner.removeHotel(this.abbreviation);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Owner> getOwners() {
        return new HashSet<>(owners);
    }

    public String getAbbreviation() {
        return abbreviation;
    }
}
