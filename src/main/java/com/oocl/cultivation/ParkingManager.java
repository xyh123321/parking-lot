package com.oocl.cultivation;

import java.util.LinkedList;
import java.util.List;

public class ParkingManager {
    private List<Object> managementList;

    public ParkingManager() {
        this.managementList = new LinkedList<>();
    }

    public boolean addMember(Object obj) {
        if(obj != null){
            this.managementList.add(obj);
            return true;
        }
        return false;
    }

    public List<Object> getManagementList() {
        return managementList;
    }

    public Ticket specifyPark(StandardParkingBoy standardParkingBoy, Car car) {
        if(!this.managementList.contains(standardParkingBoy)){
            return null;
        }
        return standardParkingBoy.park(car);
    }

    public Car specifyFetch(StandardParkingBoy standardParkingBoy, Ticket ticket) {
        return new Car(ticket.getTicketId());
    }
}
