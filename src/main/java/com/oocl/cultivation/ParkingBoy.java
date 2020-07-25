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

    public String park(Car car){
        if(car!=null && this.parkingLot.addCar(car)){
            Ticket ticket = new Ticket(car.getCarId());
            return ticket.getTicketId();
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
