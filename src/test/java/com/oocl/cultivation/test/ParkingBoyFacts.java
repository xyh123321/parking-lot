package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingBoy;
import com.oocl.cultivation.ParkingLot;
import com.oocl.cultivation.Ticket;
import org.junit.jupiter.api.Test;

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
        Ticket ticket = new Ticket("jaydenCar");
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingLot parkingLot = new ParkingLot();

        //when
        boolean car = parkingBoy.fetchCar(ticket, parkingLot);

        //then
        assertEquals(true, car);
    }
}
