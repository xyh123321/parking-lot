package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingBoy;
import com.oocl.cultivation.ParkingLot;
import com.oocl.cultivation.Ticket;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        Car car = parkingBoy.fetchCar(ticket);

        //then
        assertEquals(car.getCarId(), ticket.getTicketId());
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


}
