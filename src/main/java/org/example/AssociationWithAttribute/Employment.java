package org.example.AssociationWithAttribute;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Employment {
    private LocalDate start;
    private LocalDate end;
    private BigDecimal compensation;

    private Employee employee;
    private Hotel hotel;

    public Employment(LocalDate start, LocalDate end, BigDecimal compensation, Employee employee, Hotel hotel) {
        if (employee == null || hotel == null) { throw new IllegalArgumentException(); }
        this.start = start;
        this.end = end;
        this.compensation = compensation;
        this.employee = employee;
        this.hotel = hotel;
        
        employee.addEmployment(this);
        hotel.addEmployment(this);
    }

    public Employment(LocalDate start, BigDecimal compensation, Employee employee, Hotel hotel) {
        if (employee == null || hotel == null) { throw new IllegalArgumentException(); }
        this.start = start;
        this.compensation = compensation;
        this.employee = employee;
        this.hotel = hotel;

        employee.addEmployment(this);
        hotel.addEmployment(this);
    }
    
    public void removeEmployment() {
        this.employee.removeEmployment(this);
        this.hotel.removeEmployment(this);
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }

    public BigDecimal getCompensation() {
        return compensation;
    }

    public void setCompensation(BigDecimal compensation) {
        this.compensation = compensation;
    }

    public Employee getEmployee() {
        return employee;
    }

    public Hotel getHotel() {
        return hotel;
    }
}
