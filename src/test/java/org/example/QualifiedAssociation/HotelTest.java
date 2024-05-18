package org.example.QualifiedAssociation;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class HotelTest {
    @Test
    void createsAssociationWithOwner() {
        var h1 = new Hotel("Hotel Słoneczny", "S001");
        var o1 = new Owner("Adam Gessler");
        h1.addOwner(o1);
        
        assertAll(
                () -> assertEquals(o1.getName(), new ArrayList<>(h1.getOwners()).getFirst().getName()),
                () -> assertEquals(h1.getName(), o1.getHotels().get("S001").getName())
        );
    }

    @Test
    void removesAssociationWithOwner() {
        var h1 = new Hotel("Hotel Słoneczny", "S001");
        var o1 = new Owner("Adam Gessler");
        h1.addOwner(o1);
        h1.removeOwner(o1);

        assertAll(
                () -> assertEquals(o1.getHotels(), new HashMap<>()),
                () -> assertEquals(h1.getOwners(), new HashSet<>())
        );
    }
}