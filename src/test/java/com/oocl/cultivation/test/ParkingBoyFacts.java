package com.oocl.cultivation.test;

import com.oocl.cultivation.*;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ParkingBoyFacts {

    @Test
    void should_return_ticket_when_park_given_a_car_and_parkingboy() {
        //given
        Car car = new Car("jaydenCar");
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy();

        //when
        Ticket ticket = standardParkingBoy.park(car);

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
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLot);

        //when
        Car car = standardParkingBoy.fetchCar(ticket);

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

        StandardParkingBoy standardParkingBoy = new StandardParkingBoy();

        //when
        List<Ticket> tickets = standardParkingBoy.park(cars);

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

        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLot);

        //when
        Car jdCar = standardParkingBoy.fetchCar(jaydenTicket);
        Car suCar = standardParkingBoy.fetchCar(susanTicket);

        //then

        assertEquals(jaydenTicket.getTicketId()+susanTicket.getTicketId(), jdCar.getCarId()+suCar.getCarId());

    }

    @Test
    void should_return_unrecognized_tips_when_fetch_car_given_wrong_ticket_parkingboy() {
        //given
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy();

        Ticket wrongTicket = new Ticket("used:jaydencar");

        //when

        String tips = standardParkingBoy.validTicket(wrongTicket);


        //then
        assertEquals("Unrecognized parking ticket.", tips);
    }

    @Test
    void should_return_provide_tips_when_fetch_car_given_no_ticket_parkingboy() {
        //given
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy();

        //when
        String tips = standardParkingBoy.validTicket(null);

        //then
       assertEquals("Please provide your parking ticket.", tips);
    }

    @Test
    void should_return_not_enough_position_when_park_given_car_and_no_position_parkinglot() {
        //given
        Car car = new Car("jaydenCar");
        ParkingLot parkingLot = new ParkingLot(0);

        //when
        String tips = parkingLot.isFullOfLotSpace();

        //then
        assertEquals("Not enough position.",tips);
    }

    @Test
    void should_return_no_ticket_when_park_given_no_car_parkingboy_parkinglot() {
        //given
        ParkingLot parkingLot = new ParkingLot();

        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLot);

        //when
        Ticket ticket = standardParkingBoy.park((Car) null);

        //then
        assertNull(ticket);
    }

    @Test
    void should_return_lot1_ticket_when_park_given_car_pakingboy_2_pakinglots_all_has_position() {
        //given
        Car car = new Car("jaydenCar");
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(2);

        //when
        Ticket ticket = standardParkingBoy.park(car);

        //then
        assertEquals("lot1:jaydenCar", ticket.getTicketId());
    }

    @Test
    void should_return_lot2_ticket_when_park_given_car_pakingboy_1lot_noposition_and_2lot_hasposition() {
        //given
        Car car = new Car("jaydenCar");
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(2);
        for (int i = 0; i < 10; i++) {
            standardParkingBoy.park(new Car(i+"car"));
        }

        //when
        Ticket ticket = standardParkingBoy.park(car);

        //then
        assertEquals("lot2:jaydenCar", ticket.getTicketId());
    }

    @Test
    void should_return_no_positon_when_park_given_car_pakingboy_2_lots_all_noposition() {
        //given
        Car car = new Car("jaydenCar");
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(2);
        for (int i = 0; i < 20; i++) {
            standardParkingBoy.park(new Car(i+"car"));
        }

        //when
        String tips = standardParkingBoy.getParkingLotList().get(standardParkingBoy.getParkingLotList().size()-1).isFullOfLotSpace();

        //then
        assertEquals("Not enough position.", tips);
    }

    @Test
    void should_return_lot2_ticket_when_smart_parking_given_car_smart_parkingboy_and_2lots() {
        //given
        Car car = new Car("jaydenCar");

        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(2);
        smartParkingBoy.park(new Car("car"));

        //when
        Ticket ticket = smartParkingBoy.park(car);

        //then
        assertEquals("lot2:jaydenCar", ticket.getTicketId());
    }

    @Test
    void should_return_unrecognized_tips_when_smart_fetch_car_given_wrong_ticket_parkingboy() {
        //given
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(2);

        Ticket wrongTicket = new Ticket("used:jaydencar");

        //when
        String tips = smartParkingBoy.validTicket(wrongTicket);

        //then
        assertEquals("Unrecognized parking ticket.", tips);
    }

    @Test
    void should_return_provide_tips_when_smart_fetch_car_given_no_ticket_smart_parkingboy() {
        //given
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(2);

        //when
        String tips = smartParkingBoy.validTicket(null);

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
        String tips = parkingLotList.get(parkingLotList.size()-1).isFullOfLotSpace();

        //then
        assertEquals("Not enough position.",tips);
    }

    @Test
    void should_return_lot2_ticket_when_super_smart_parking_given_car_smart_parkingboy_and_3lots_with_diffentspace() {
        //given
        Car car = new Car("jaydenCar");
        int[] lotSpace = {10, 5, 12};
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(3,lotSpace);
        superSmartParkingBoy.park(new Car("testCar"));

        //when
        Ticket ticket = superSmartParkingBoy.park(car);

        //then
        assertEquals("lot2:jaydenCar", ticket.getTicketId());
    }

    @Test
    void should_return_unrecognized_tips_when_super_smart_fetch_car_given_wrong_ticket_super_smart_parkingboy() {
        //given
        int[] lotSpace = {10, 5, 12};
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(3,lotSpace);

        Ticket wrongTicket = new Ticket("used:jaydencar");

        //when
        String tips = superSmartParkingBoy.validTicket(wrongTicket);

        //then
        assertEquals("Unrecognized parking ticket.", tips);
    }

    @Test
    void should_return_provide_tips_when_super_smart_fetch_car_given_no_ticket_super_smart_parkingboy() {
        //given
        int[] lotSpace = {10, 5, 12};
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(3,lotSpace);

        //when
        String tips = superSmartParkingBoy.validTicket(null);

        //then
        assertEquals("Please provide your parking ticket.", tips);
    }

    @Test
    void should_return_no_position_tips_when_super_smart_park_given_car_super_smart_parkingboy_and_no_position_parkinglot() {
        //given
        Car car = new Car("jaydenCar");

        int[] lotSpace = {0, 0,0};
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(3,lotSpace);

        //when
        Ticket ticket = superSmartParkingBoy.park(car);
        String tips = ticket == null ? "Not enough position." : "enough position";
        //then
        assertEquals("Not enough position.",tips);
    }

    @Test
    void should_return_true_when_add_parkingboy_given_manager_parkingboy() {
        //given
        ParkingManager parkingManager = new ParkingManager();
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy();

        //when
        boolean isAdd = parkingManager.addMember(standardParkingBoy);

        //then
        assertTrue(isAdd);
    }

    @Test
    void should_return_ticket_when_specify_park_given_manager_parkingboy_car() {
        //given
        ParkingManager parkingManager = new ParkingManager();
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy();
        parkingManager.addMember(standardParkingBoy);
        Car car = new Car("car");

        //when
        Ticket ticket = parkingManager.specifyPark(standardParkingBoy,car);

        //then
        assertEquals("car", ticket.getTicketId());
    }

    @Test
    void should_return_tips_when_specify_park_given_manager_car_parkingboy_not_on_list() {
        //given
        ParkingManager parkingManager = new ParkingManager();

        StandardParkingBoy standardParkingBoy = new StandardParkingBoy();
        Car car = new Car("car");

        //when
        Ticket ticket = parkingManager.specifyPark(standardParkingBoy,car);

        //then
        assertNull(ticket);
    }

    @Test
    void should_return_car_when_specify_fetch_given_manager_parkingboy_ticket() {
        //given
        ParkingManager parkingManager = new ParkingManager();

        StandardParkingBoy standardParkingBoy = new StandardParkingBoy();
        parkingManager.addMember(standardParkingBoy);
        Ticket ticket = standardParkingBoy.park(new Car("specifyCar"));

        //when
        Car car = parkingManager.specifyFetch(standardParkingBoy, ticket);

        //then
        assertEquals("specifyCar", car.getCarId());
    }
}
