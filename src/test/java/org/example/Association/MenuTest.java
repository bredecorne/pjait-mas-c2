package org.example.Association;

import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class MenuTest {
    @Test
    void createsAssociationWithMenu() {
        var m1 = new Menu("Continental Breakfast", "Delicious morning spread");
        var h1 = new Hotel("Grand Hotel", "GH");
        var h2 = new Hotel("Home Hotel", "HH");
        m1.addHotel(h1);
        m1.addHotel(h2);

        var e1 = new HashSet<Hotel>();
        e1.add(h1);
        e1.add(h2);

        var e2 = new HashSet<Menu>();
        e2.add(m1);

        assertAll(
                () -> assertEquals(e1, m1.getHotels()),
                () -> assertEquals(e2, h1.getMenus()),
                () -> assertEquals(e2, h2.getMenus())
        );
    }
}