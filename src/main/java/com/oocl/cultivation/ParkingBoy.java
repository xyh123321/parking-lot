package com.oocl.cultivation;

public class ParkingBoy {

    public Ticket park(Car car){
        Ticket ticket = new Ticket(car.getCarId());
        return ticket;
    }

    public Car fetchCar(Ticket ticket, ParkingLot parkingLot) {
        Car car = parkingLot.searchCar(ticket);
        return car;
    }
}
