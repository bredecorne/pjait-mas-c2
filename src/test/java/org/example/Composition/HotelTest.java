package org.example.Composition;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class HotelTest {
    @Test
    void throwsExceptionWhenSettingOccupiedRoomNumber() {
        var h1 = new Hotel("Hotel Słoneczny", "H0001");
        var r1 = h1.getRooms();
        h1.addRoom(101);
        h1.addRoom(102);
        
        assertThrows(
                IllegalArgumentException.class, 
                () -> r1.getFirst().setNumber(102));
    }

    @Test
    void removesRoomByNumber() {
        var h1 = new Hotel("Hotel Słoneczny", "H0001");
        var r1 = h1.getRooms();
        h1.addRoom(101);
        h1.removeRoom(101);

        assertEquals(
                new ArrayList<Hotel.Room>(),
                r1
        );
    }
}