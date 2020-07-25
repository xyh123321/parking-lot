package com.oocl.cultivation;

import java.util.LinkedList;

public class SuperSmartParkingBoy extends ParkingBoy{
   private int lotNumber;
   private int[] lotSpace;

    public SuperSmartParkingBoy(int lotNumber, int[] lotSpace) {
        this.parkingLotList = new LinkedList<>();
        for (int num = 1; num < lotNumber+1; num++) {
            ParkingLot parkingLot = new ParkingLot("lot"+num);
            parkingLot.setParkingSpace(lotSpace[num-1]);
            this.parkingLotList.add(parkingLot);
        }
    }
}
