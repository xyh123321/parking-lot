package com.oocl.cultivation;

import java.util.LinkedList;

public class SuperSmartParkingBoy extends StandardParkingBoy {
   private int lotNumber;
   private int[] lotSpace;

    public SuperSmartParkingBoy(int lotNumber, int[] lotSpace) {
        this.parkingLotList = new LinkedList<>();
        for (int num = 1; num < lotNumber+1; num++) {
            ParkingLot parkingLot = new ParkingLot("lot"+num);
            parkingLot.setParkingSpace(lotSpace[num-1]);
            parkingLot.setOriginSpace(lotSpace[num-1]);
            this.parkingLotList.add(parkingLot);
        }
    }

    @Override
    protected Ticket searchPark(Car car) {
        int space = 0;
        int lotNum = -1;
        for (int i = 0; i < this.parkingLotList.size(); i++) {
            if(this.parkingLotList.get(i).getParkingSpace()!=0&&this.parkingLotList.get(i).getParkingSpace()/this.parkingLotList.get(i).getOriginSpace()>space){
                space = this.parkingLotList.get(i).getParkingSpace()/this.parkingLotList.get(i).getOriginSpace();
                lotNum = i;
            }
        }
        if(lotNum !=-1){
            if(this.parkingLotList.get(lotNum).addCar(car)){
                return  new Ticket(this.parkingLotList.get(lotNum).getLotName()+":"+car.getCarId());
            }
        }
        return null;
    }
}
