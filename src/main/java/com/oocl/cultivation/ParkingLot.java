package com.oocl.cultivation;

import java.util.LinkedList;
import java.util.List;

public class ParkingLot {
    private String lotName;
    private int parkingSpace;
    private int originSpace;
    private List<Car> cars;

    public ParkingLot() {
        this.cars = new LinkedList<>();
        this.parkingSpace = 10;
        this.lotName = "";
    }

    public ParkingLot(int parkingSpace) {
        this.cars = new LinkedList<>();
        this.parkingSpace = parkingSpace;
        this.lotName = "";
    }

    public ParkingLot(String lotName) {
        this.lotName = lotName;
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
        if(this.parkingSpace !=0){
            this.setParkingSpace(this.parkingSpace-1);
            this.cars.add(car);
            return true;
        }
        return false;
    }

    public String getLotName() {
        return lotName;
    }

    public int getParkingSpace() {
        return parkingSpace;
    }

    public void setParkingSpace(int parkingSpace) {
        this.parkingSpace = parkingSpace;
    }

    public void setOriginSpace(int originSpace) {
        this.originSpace = originSpace;
    }

    public int getOriginSpace() {
        return originSpace;
    }
}
