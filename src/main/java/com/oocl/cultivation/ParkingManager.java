package com.oocl.cultivation;

import java.util.LinkedList;
import java.util.List;

public class ParkingManager {
    private List<Object> managementList;

    public ParkingManager() {
        this.managementList = new LinkedList<>();
    }

    public boolean addMember(Object obj) {
        return false;
    }

    public List<Object> getManagementList() {
        return managementList;
    }
}
