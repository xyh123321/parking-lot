package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingBoy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ParkingBoyFacts {
    @Test
    void should_return_ticket_when_park_given_a_car() {
        //given
        Car car = new Car("jaydenCar");
        ParkingBoy parkingBoy = new ParkingBoy();

        //when
        String ticket = parkingBoy.park(car);

        //then
        assertEquals(car.getCarId(), ticket);
    }

}
