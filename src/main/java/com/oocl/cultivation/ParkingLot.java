package com.oocl.cultivation;

import java.util.LinkedList;
import java.util.List;

public class ParkingLot {
    private int parkingSpace;
    private List<Car> cars;

    public ParkingLot() {
        this.cars = new LinkedList<>();
        this.parkingSpace = 10;
    }

    public Car searchCar(Ticket ticket) {
        for (Car car : cars) {
            if(car.getCarId().equals(ticket.getTicketId())){
                return car;
            }
        }
        return null;
    }

    public boolean addCar(Car car) {
        this.cars.add(car);
        return true;
    }
}
