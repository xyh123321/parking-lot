package com.oocl.cultivation;

import java.util.LinkedList;
import java.util.List;

public class ParkingBoy {
    private ParkingLot parkingLot;

    public ParkingBoy() {
        this.parkingLot = new ParkingLot();
    }

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public Ticket park(Car car){
        if(car!=null && this.parkingLot.addCar(car)){
            Ticket ticket = new Ticket(car.getCarId());
            return ticket;
        }
        return null;
    }

    public Car fetchCar(Ticket ticket) {
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
