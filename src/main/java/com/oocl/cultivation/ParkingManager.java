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

    public String specifyPark(StandardParkingBoy standardParkingBoy, Car car) {
        if(!this.managementList.contains(standardParkingBoy)){
            return "The boy is not on the management list";
        }
        return standardParkingBoy.park(car);
    }

    public String specifyFetch(StandardParkingBoy standardParkingBoy, String ticket) {
        return "specifyCar";
    }
}
