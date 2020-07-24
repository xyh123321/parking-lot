package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingBoy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ParkingBoyFacts {
    @Test
    void should_return_carid_when_parking_lot_given_a_car() {
        //given
        Car car = new Car("jayden");
        ParkingBoy parkingBoy = new ParkingBoy();

        //when
        String res = parkingBoy.park(car);

        //then
        assertEquals(car.getCarId(), res);
    }

}
