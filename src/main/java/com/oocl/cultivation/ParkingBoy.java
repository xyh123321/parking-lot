package com.oocl.cultivation;

import java.util.LinkedList;
import java.util.List;

public class ParkingBoy {
    private ParkingLot parkingLot;
    private List<ParkingLot> parkingLotList;

    public ParkingBoy() {
        this.parkingLot = new ParkingLot();
    }

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public ParkingBoy(int lotNumber) {
        this.parkingLotList = new LinkedList<>();
        for (int num = 0; num < lotNumber; num++) {
            ParkingLot parkingLot = new ParkingLot("lot"+num);
            this.parkingLotList.add(parkingLot);
        }
    }

    public String park(Car car){
        if(this.parkingLotList!=null && !this.parkingLotList.isEmpty()){
            return searchPark(car);
        }
        if(car!=null){
            if(this.parkingLot.addCar(car)){
                Ticket ticket = new Ticket(car.getCarId());
                return ticket.getTicketId();
            }
            return "Not enough position.";
        }
        return "";
    }

    private String searchPark(Car car) {
        for (int i = 0; i < this.parkingLotList.size(); i++) {
            if(this.parkingLotList.get(i).addCar(car)){
                return "";
            }
        }
        return "";
    }

    public String fetchCar(Ticket ticket) {
        String illegalTicket = validTicket(ticket);
        if(illegalTicket.isEmpty()){
            Car car = parkingLot.searchCar(ticket);
            if(car == null){
                return "no car.";
            }
            return car.getCarId();
        }
        return illegalTicket;
    }

    public List<Ticket> park(List<Car> cars) {
        List<Ticket> tickets = new LinkedList<>();
        for (Car car: cars) {
            tickets.add(new Ticket(car.getCarId()));
        }
        return tickets;
    }

    public String validTicket(Ticket ticket) {
        if(ticket == null) {
            return "Please provide your parking ticket.";
        }
        if(ticket.getTicketId().contains("used")){
            return "Unrecognized parking ticket.";
        }
        return "";
    }
}
