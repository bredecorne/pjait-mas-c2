package org.example.Association;

import org.junit.jupiter.api.Test;
import java.util.HashSet;
import static org.junit.jupiter.api.Assertions.*;

class HotelTest {
    @Test
    void createsAssociationWithMenu() {
        var h1 = new Hotel("Grand Hotel", "GH");
        var m1 = new Menu("Continental Breakfast", "Delicious morning spread");
        var m2 = new Menu("Gourmet Dinner", "Exquisite dining experience");
        h1.addMenu(m1);
        h1.addMenu(m2);
        
        var e1 = new HashSet<Menu>();
        e1.add(m1);
        e1.add(m2);
        
        var e2 = new HashSet<Hotel>();
        e2.add(h1);
        
        assertAll(
                () -> assertEquals(e1, h1.getMenus()),
                () -> assertEquals(e2, m1.getHotels()),
                () -> assertEquals(e2, m2.getHotels())
        );
    }

    @Test
    void removesAssociationWithMenu() {
        var h1 = new Hotel("Grand Hotel", "GH");
        var m1 = new Menu("Continental Breakfast", "Delicious morning spread");
        var m2 = new Menu("Gourmet Dinner", "Exquisite dining experience");
        h1.addMenu(m1);
        h1.addMenu(m2);
        h1.removeMenu(m1);

        var expectedMenus = new HashSet<Menu>();
        expectedMenus.add(m2);

        var expectedHotelsM1 = new HashSet<Hotel>();
        var expectedHotelsM2 = new HashSet<Hotel>();
        expectedHotelsM2.add(h1);

        assertAll(
                () -> assertEquals(expectedMenus, h1.getMenus()),
                () -> assertEquals(expectedHotelsM1, m1.getHotels()),
                () -> assertEquals(expectedHotelsM2, m2.getHotels())
        );
    }
}