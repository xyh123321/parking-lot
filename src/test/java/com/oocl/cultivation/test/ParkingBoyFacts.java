package com.oocl.cultivation.test;

import com.oocl.cultivation.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNull;

class ParkingBoyFacts {

    @Test
    void should_return_ticket_when_park_given_a_car_and_parkingboy() {
        //given
        Car car = new Car("jaydenCar");
        ParkingBoy parkingBoy = new ParkingBoy();

        //when
        String ticketId = parkingBoy.park(car);

        //then
        assertEquals(car.getCarId(), ticketId);
    }

    @Test
    void should_return_correct_car_when_fetch_car_given_ticket_parkingboy_parkinglot() {
        //given
        Car mockCar = new Car("jaydenCar");
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.addCar(mockCar);

        Ticket ticket = new Ticket("jaydenCar");
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);

        //when
        String car = parkingBoy.fetchCar(ticket);

        //then
        assertEquals(car, ticket.getTicketId());
    }

    @Test
    void should_return_2_tickets_when_park_2_cars_given_pakingboy_and_2cars() {
        //given
        Car jaydenCar = new Car("jaydenCar");
        Car susanCar = new Car("susanCar");
        List<Car> cars = new LinkedList<>();
        cars.add(jaydenCar);
        cars.add(susanCar);

        ParkingBoy parkingBoy = new ParkingBoy();

        //when
        List<Ticket> tickets = parkingBoy.park(cars);

        //then
        assertEquals(tickets.size(),2);
    }

    @Test
    void should_return_correct_2cars_when_fetch_car_given_2tickets_parkingboy_parkinglot() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.addCar(new Car("jaydenCar"));
        parkingLot.addCar(new Car("susanCar"));

        Ticket jaydenTicket = new Ticket("jaydenCar");
        Ticket susanTicket = new Ticket("susanCar");

        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);

        //when
        String jdCar = parkingBoy.fetchCar(jaydenTicket);
        String suCar = parkingBoy.fetchCar(susanTicket);

        //then

        assertEquals(jaydenTicket.getTicketId()+susanTicket.getTicketId(), jdCar+suCar);

    }

    @Test
    void should_return_unrecognized_tips_when_fetch_car_given_wrong_ticket_parkingboy() {
        //given
        ParkingBoy parkingBoy = new ParkingBoy();

        Ticket wrongTicket = new Ticket("used:jaydencar");

        //when
        String tips = parkingBoy.fetchCar(wrongTicket);

        //then
        assertEquals("Unrecognized parking ticket.", tips);
    }

    @Test
    void should_return_provide_tips_when_fetch_car_given_no_ticket_parkingboy() {
        //given
        ParkingBoy parkingBoy = new ParkingBoy();

        //when
        String tips = parkingBoy.fetchCar(null);

        //then
       assertEquals("Please provide your parking ticket.", tips);
    }

    @Test
    void should_return_no_ticket_when_park_given_car_parkingboy_and_no_position_parkinglot() {
        //given
        Car car = new Car("jaydenCar");
        ParkingLot parkingLot = new ParkingLot(0);

        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);

        //when
        String ticketId = parkingBoy.park(car);

        //then
        assertEquals("Not enough position.",ticketId);
    }

    @Test
    void should_return_no_ticket_when_park_given_no_car_parkingboy_parkinglot() {
        //given
        ParkingLot parkingLot = new ParkingLot();

        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);

        //when
        String ticketId = parkingBoy.park((Car) null);

        //then
        assertEquals("",ticketId);
    }

    @Test
    void should_return_lot1_ticket_when_park_given_car_pakingboy_2_pakinglots_all_has_position() {
        //given
        Car car = new Car("jaydenCar");
        ParkingBoy parkingBoy = new ParkingBoy(2);

        //when
        String ticket = parkingBoy.park(car);

        //then
        assertEquals("lot1:jaydenCar", ticket);
    }

    @Test
    void should_return_lot2_ticket_when_park_given_car_pakingboy_1lot_noposition_and_2lot_hasposition() {
        //given
        Car car = new Car("jaydenCar");
        ParkingBoy parkingBoy = new ParkingBoy(2);
        for (int i = 0; i < 10; i++) {
            parkingBoy.park(new Car(i+"car"));
        }

        //when
        String ticket = parkingBoy.park(car);

        //then
        assertEquals("lot2:jaydenCar", ticket);
    }

    @Test
    void should_return_no_positon_when_park_given_car_pakingboy_2_lots_all_noposition() {
        //given
        Car car = new Car("jaydenCar");
        ParkingBoy parkingBoy = new ParkingBoy(2);
        for (int i = 0; i < 20; i++) {
            parkingBoy.park(new Car(i+"car"));
        }

        //when
        String ticket = parkingBoy.park(car);

        //then
        assertEquals("Not enough position.", ticket);
    }

    @Test
    void should_return_lot2_ticket_when_smart_parking_given_car_smart_parkingboy_and_2lots() {
        //given
        Car car = new Car("jaydenCar");

        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(2);
        smartParkingBoy.park(new Car("car"));

        //when
        String ticket = smartParkingBoy.park(car);

        //then
        assertEquals("lot2:jaydenCar", ticket);
    }

    @Test
    void should_return_unrecognized_tips_when_smart_fetch_car_given_wrong_ticket_parkingboy() {
        //given
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(2);

        Ticket wrongTicket = new Ticket("used:jaydencar");

        //when
        String tips = smartParkingBoy.fetchCar(wrongTicket);

        //then
        assertEquals("Unrecognized parking ticket.", tips);
    }

    @Test
    void should_return_provide_tips_when_smart_fetch_car_given_no_ticket_smart_parkingboy() {
        //given
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(2);

        //when
        String tips = smartParkingBoy.fetchCar(null);

        //then
        assertEquals("Please provide your parking ticket.", tips);
    }

    @Test
    void should_return_no_position_tips_when_smart_park_given_car_smartparkingboy_and_no_position_parkinglot() {
        //given
        Car car = new Car("jaydenCar");

        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(2);

        List<ParkingLot> parkingLotList = smartParkingBoy.getParkingLotList();
        for (ParkingLot p: parkingLotList) {
            p.setParkingSpace(0);
        }

        //when
        String ticketId = smartParkingBoy.park(car);

        //then
        assertEquals("Not enough position.",ticketId);
    }

    @Test
    void should_return_lot2_ticket_when_super_smart_parking_given_car_smart_parkingboy_and_3lots_with_diffentspace() {
        //given
        Car car = new Car("jaydenCar");
        int[] lotSpace = {10, 5, 12};
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(3,lotSpace);
        superSmartParkingBoy.park(new Car("testCar"));

        //when
        String ticket = superSmartParkingBoy.park(car);

        //then
        assertEquals("lot2:jaydenCar", ticket);
    }
}
