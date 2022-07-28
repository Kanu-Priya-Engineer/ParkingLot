public class AllocationSystem {

    public boolean checkAvailability(){
        if(ParkingManagementSystem.availableSpace > 0){
            return true;
        }
        else{
            return false;
        }
    }

    public String parkCar(Car newCar){
        String message;

        if(checkAvailability()){
            for ( int index = 0; index<ParkingManagementSystem.parkingSlots.size(); index++ ){
                if(ParkingManagementSystem.parkingSlots.get(index) == null)
                {
                    message = "Your car parked successfully.";
                    ParkingManagementSystem.parkingSlots.set(index, newCar);
                    ParkingManagementSystem.availableSpace -= 1;
                    return message;
                }
            }

        }

        message = "Sorry! All seats are occupied";
        return message;
    }

    public String removeCar(Car car){
        String message;
        for ( int index = 0; index<ParkingManagementSystem.parkingSlots.size(); index++ ){
            if(ParkingManagementSystem.parkingSlots.get(index) != null && (ParkingManagementSystem.parkingSlots.get(index).getCarNumber().equals(car.getCarNumber())))
            {
                ParkingManagementSystem.parkingSlots.set(index, null);
                ParkingManagementSystem.availableSpace += 1;
                message = "Your car removed successfully.";
                return message;
            }
        }
        message = "This car is not parked.";
        return message;
    }

}
