package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingBoy;
import com.oocl.cultivation.ParkingLot;
import com.oocl.cultivation.Ticket;
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
        Ticket ticket = parkingBoy.park(car);

        //then
        assertEquals(car.getCarId(), ticket.getTicketId());
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

        Ticket wrongTicket = new Ticket("");

        //when
        String tips = parkingBoy.fetchCar(wrongTicket);

        //then
        assertEquals("Unrecognized parking ticket.", tips);
    }

    @Test
    void should_return_no_car_when_fetch_car_given_used_ticket_parkingboy() {
        //given
        ParkingBoy parkingBoy = new ParkingBoy();

        Ticket usedTicket = new Ticket("used:jaydenCae");

        //when
        String car = parkingBoy.fetchCar(usedTicket);

        //then
        assertNull(car,"the ticket is used!");
    }

    @Test
    void should_return_no_ticket_when_park_given_car_parkingboy_parkinglot() {
        //given
        Car car = new Car("jaydenCar");
        ParkingLot parkingLot = new ParkingLot(0);

        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);

        //when
        Ticket ticket = parkingBoy.park(car);

        //then
        assertNull(ticket);
    }

    @Test
    void should_return_no_ticket_when_park_given_no_car_parkingboy_parkinglot() {
        //given
        ParkingLot parkingLot = new ParkingLot();

        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);

        //when
        Ticket ticket = parkingBoy.park((Car) null);

        //then
        assertNull(ticket);
    }

}
