import java.util.ArrayList;
import java.util.Scanner;

public class ParkingManagementSystem {
    public static final Integer totalSpace = 5;
    public static Integer availableSpace = 5;
    public static ArrayList<Car> parkingSlots= new ArrayList<Car>(totalSpace);


    public static void main(String[] args){

        for(int index = 0; index<totalSpace; index++){
            parkingSlots.add(index, null);
        }

        int choice;
        do {
            System.out.println("Welcome to the Parking Management System!");
            System.out.println("Choose from the options : ");
            System.out.println("1. Park a car ");
            System.out.println("2. Remove a car ");
            System.out.println("3. Exit ");

            Scanner sc = new Scanner(System.in);
            choice = sc.nextInt();
            AllocationSystem allocationSystem = new AllocationSystem();
            Car car;
            String carNumber="";
            String successMessage="";
            switch (choice) {
                case 1:
                    car = new Car();
                    System.out.println("Enter the car number: ");
                    carNumber = sc.next();
                    car.setCarNumber(carNumber);
                    successMessage = allocationSystem.parkCar(car);
                    System.out.println(successMessage);
                    System.out.println();
                    break;
                case 2:
                    car = new Car();
                    System.out.println("Enter the car number: ");
                    carNumber = sc.next();
                    car.setCarNumber(carNumber);
                    successMessage =  allocationSystem.removeCar(car);
                    System.out.println(successMessage);
                    System.out.println();
                    break;
                default:
                    System.out.println("Please ! Enter the valid options [1,2,3]");
                    System.out.println();
            }
        } while (choice != 3);


        System.out.println("Goodbye.");
    }

}
