package org.example.QualifiedAssociation;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class OwnerTest {
    @Test
    void createsAssociationWithHotel() {
        var h1 = new Hotel("Hotel Słoneczny", "S001");
        var o1 = new Owner("Adam Gessler");
        o1.addHotel(h1);

        assertAll(
                () -> assertEquals(o1.getName(), new ArrayList<>(h1.getOwners()).getFirst().getName()),
                () -> assertEquals(h1.getName(), o1.getHotels().get("S001").getName())
        );
    }

    @Test
    void failsOnOccupiedAbbreviationAssociation() {
        var h1 = new Hotel("Hotel Słoneczny", "S001");
        var h2 = new Hotel("Hotel Meksyk", "S001");
        var o1 = new Owner("Adam Gessler");
        o1.addHotel(h1);
        o1.addHotel(h2);
        var expected = new HashMap<String, Hotel>();
        expected.put("S001", h1);

        assertEquals(expected, o1.getHotels());
    }

    @Test
    void removesAssociationWithHotel() {
        var h1 = new Hotel("Hotel Słoneczny", "S001");
        var o1 = new Owner("Adam Gessler");
        o1.addHotel(h1);
        o1.removeHotel(h1);

        assertAll(
                () -> assertEquals(o1.getHotels(), new HashMap<>()),
                () -> assertEquals(h1.getOwners(), new HashSet<>())
        );
    }
}