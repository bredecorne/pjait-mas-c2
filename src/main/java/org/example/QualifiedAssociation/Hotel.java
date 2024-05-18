package org.example.QualifiedAssociation;

import java.util.HashSet;
import java.util.Set;

public class Hotel {
    private String name;
    private final Set<Owner> owners = new HashSet<>();

    public Hotel(String name) {
        this.name = name;
    }
    
    public void addOwner(Owner owner) {
        if (owners.contains(owner)) { throw new IllegalArgumentException(); }
        owners.add(owner);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
