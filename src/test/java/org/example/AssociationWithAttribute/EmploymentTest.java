package org.example.AssociationWithAttribute;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class EmploymentTest {

    @Test
    void createsAssociation() {
        var employee = new Employee("Wiktor Biszkopt");
        var hotel = new Hotel("Biszkopt i spółka", "BIS");
        
        var employment = new Employment(LocalDate.of(2022, 10, 10), BigDecimal.valueOf(17.70), employee, hotel);
        
        assertEquals(employee.getEmployments(), hotel.getEmployments());
    }

    @Test
    void removesAssociation() {
        var employee = new Employee("Wiktor Biszkopt");
        var hotel1 = new Hotel("Biszkopt i spółka", "BIS");
        var hotel2 = new Hotel("Spółka i biszkopt", "SIB");
        var employment1 = new Employment(LocalDate.of(2022, 10, 10), BigDecimal.valueOf(17.70), employee, hotel1);
        var employment2 = new Employment(LocalDate.of(2022, 10, 10), BigDecimal.valueOf(17.70), employee, hotel2);
        
        employee.removeEmployment(employment1);

        assertEquals(employee.getEmployments(), hotel2.getEmployments());
    }
}