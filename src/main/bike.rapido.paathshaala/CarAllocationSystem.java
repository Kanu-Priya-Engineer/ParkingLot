import java.util.ArrayList;

public class CarAllocationSystem {
    private  Integer availableSpace = 2;
    private  ArrayList<Car> parkingSlots= new ArrayList<Car>();

    public CarAllocationSystem() {
         this.setParkingSlots(this.parkingSlots);
    }

    public  Integer getAvailableSpace() {
        return availableSpace;
    }


    public  ArrayList<Car> getParkingSlots() {
        return parkingSlots;
    }

    public  void setParkingSlots(ArrayList<Car> parkingSlots) {
        this.parkingSlots = parkingSlots;
        if(parkingSlots.size()==0) {
            for (int index = 0; index < availableSpace; index++) {
                parkingSlots.add(index, null);
            }
        }
        else {
            for (int index = 0; index < availableSpace; index++) {
                parkingSlots.set(index, null);
            }
        }
    }

    public boolean checkAvailability(){

        if(availableSpace > 0){
            return true;
        }
        else{
            return false;
        }
    }

    public String allocateSlot(Car newCar){
        String message;

        if(checkAvailability()){
            for ( int index = 0; index<parkingSlots.size(); index++ ){
                if(parkingSlots.get(index) == null)
                {
                    message = Notifications.CAR_PARKED_AT_SLOT + (index+1);
                    parkingSlots.set(index, newCar);
                    availableSpace -= 1;
                    return message;
                }
            }

        }

        message = "Sorry! All slots are occupied";
        return message;
    }

    public String deallocateSlot(Car car){
        String message;
        for ( int index = 0; index<parkingSlots.size(); index++ ){
            if(parkingSlots.get(index) != null && (parkingSlots.get(index).getCarNumber().equals(car.getCarNumber())))
            {
                parkingSlots.set(index, null);
                availableSpace += 1;
                message = "Your car removed successfully from Slot : " + (index+1);
                return message;
            }
        }
        message = "This car is not parked.";
        return message;
    }

}
