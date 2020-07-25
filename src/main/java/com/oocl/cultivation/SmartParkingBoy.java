package com.oocl.cultivation;

public class SmartParkingBoy extends ParkingBoy{


    public SmartParkingBoy(int lotNumber) {
        super(lotNumber);
    }

    @Override
    protected String searchPark(Car car) {
        int space = 0;
        String res = "Not enough position.";
        for (int i = 0; i < this.parkingLotList.size(); i++) {
            if(this.parkingLotList.get(i).getParkingSpace()>space){
                space = this.parkingLotList.get(i).getParkingSpace();
                if(this.parkingLotList.get(i).addCar(car)){
                    res =  this.parkingLotList.get(i).getLotName()+":"+car.getCarId();
                }
            }
        }
        return res;
    }
}
