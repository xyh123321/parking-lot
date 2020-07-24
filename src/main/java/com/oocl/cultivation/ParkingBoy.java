package com.oocl.cultivation;

import java.util.LinkedList;
import java.util.List;

public class ParkingBoy {

    public Ticket park(Car car){
        Ticket ticket = new Ticket(car.getCarId());
        return ticket;
    }

    public Car fetchCar(Ticket ticket, ParkingLot parkingLot) {
        Car car = parkingLot.searchCar(ticket);
        return car;
    }

    public List<Ticket> park(List<Car> cars) {
        List<Ticket> tickets = new LinkedList<>();
        for (Car car: cars) {
            tickets.add(new Ticket(car.getCarId()));
        }
        return tickets;
    }
}
