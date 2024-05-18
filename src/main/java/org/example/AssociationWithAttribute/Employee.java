package org.example.AssociationWithAttribute;

import java.util.HashSet;
import java.util.Set;

public class Employee {
    private String name;
    private final Set<Employment> employments = new HashSet<>();

    public Employee(String name) {
        this.name = name;
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

    public Set<Employment> getEmployments() {
        return new HashSet<>(employments);
    }
}
