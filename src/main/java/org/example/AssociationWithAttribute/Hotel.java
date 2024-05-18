package org.example.AssociationWithAttribute;

import java.util.HashSet;
import java.util.Set;

public class Hotel {
    private String name;
    private final String abbreviation;
    private final Set<Employment> employments = new HashSet<>();

    public Hotel(String name, String abbreviation) {
        this.name = name;
        this.abbreviation = abbreviation;
    }
    
    public void addEmployment(Employment employment) {
        if (!employments.contains(employment)) {
            employments.add(employment);
        }
    }

    public void removeEmployment(Employment employment) {
        if (employments.contains(employment)) {
            employments.remove(employment);
            employment.removeEmployment();
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

    public Set<Employment> getEmployments() {
        return new HashSet<>(employments);
    }
}