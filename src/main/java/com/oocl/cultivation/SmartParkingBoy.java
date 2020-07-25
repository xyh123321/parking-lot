package com.oocl.cultivation;

public class SmartParkingBoy extends ParkingBoy{


    public SmartParkingBoy(int lotNumber) {
        super(lotNumber);
    }

    @Override
    protected String searchPark(Car car) {
        int space = 0;
        int lotNum = -1;
        for (int i = 0; i < this.parkingLotList.size(); i++) {
            if(this.parkingLotList.get(i).getParkingSpace()>space){
                space = this.parkingLotList.get(i).getParkingSpace();
                lotNum = i;
            }
        }
        if(lotNum !=-1){
            if(this.parkingLotList.get(lotNum).addCar(car)){
                return  this.parkingLotList.get(lotNum).getLotName()+":"+car.getCarId();
            }
        }
        return "Not enough position.";
    }
}
