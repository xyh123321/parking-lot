package com.oocl.cultivation;

public class ParkingBoy {

    public Ticket park(Car car){
        Ticket ticket = new Ticket(car.getCarId());
        return ticket;
    }
}
