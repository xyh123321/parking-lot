package com.oocl.cultivation;

import java.util.LinkedList;
import java.util.List;

public class StandardParkingBoy {
    protected ParkingLot parkingLot;
    protected List<ParkingLot> parkingLotList;

    public StandardParkingBoy() {
        this.parkingLot = new ParkingLot();
    }

    public StandardParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public StandardParkingBoy(int lotNumber) {
        this.parkingLotList = new LinkedList<>();
        for (int num = 1; num < lotNumber+1; num++) {
            ParkingLot parkingLot = new ParkingLot("lot"+num);
            this.parkingLotList.add(parkingLot);
        }
    }

    public Ticket park(Car car){
        if(this.parkingLotList!=null && !this.parkingLotList.isEmpty()){
            return searchPark(car);
        }
        if(car!=null){
            if(this.parkingLot.addCar(car)){
                Ticket ticket = new Ticket(car.getCarId());
                return ticket;
            }
        }
        return null;
    }

    protected Ticket searchPark(Car car) {
        for (int i = 0; i < this.parkingLotList.size(); i++) {
            if(this.parkingLotList.get(i).addCar(car)){
                String ticketStr = this.parkingLotList.get(i).getLotName()+":"+car.getCarId();
                Ticket ticket = new Ticket(ticketStr);
                return ticket;
            }
        }
        return null;
    }

    public Car fetchCar(Ticket ticket) {
        String isLegal = validTicket(ticket);
        if("the ticket is legal.".equals(isLegal)){
            Car car = parkingLot.searchCar(ticket);
            if(car == null){
                return null;
            }
            return car;
        }
        return null;
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
        return "the ticket is legal.";
    }

    public List<ParkingLot> getParkingLotList() {
        return parkingLotList;
    }

    public void setParkingLotList(List<ParkingLot> parkingLotList) {
        this.parkingLotList = parkingLotList;
    }
}
