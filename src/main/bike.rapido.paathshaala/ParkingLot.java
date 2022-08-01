import java.util.Scanner;

public class ParkingLot {
    public static void main(String[] args){

        CarAllocationSystem carAllocationSystem = new CarAllocationSystem();
        int choice;
        do {
            System.out.println("Welcome to the Parking Management System!");
            System.out.println("Choose from the options : ");
            System.out.println("1. Park a car ");
            System.out.println("2. Remove a car ");
            System.out.println("3. Exit ");

            Scanner sc = new Scanner(System.in);
            choice = sc.nextInt();

            Car car;
            String carNumber="";
            String successMessage="";
            switch (choice) {
                case 1:
                    car = new Car();
                    System.out.println("Enter the car number: ");
                    carNumber = sc.next();
                    car.setCarNumber(carNumber);
                    successMessage = carAllocationSystem.allocateSlot(car);
                    System.out.println(successMessage);
                    System.out.println();
                    break;
                case 2:
                    car = new Car();
                    System.out.println("Enter the car number: ");
                    carNumber = sc.next();
                    car.setCarNumber(carNumber);
                    successMessage =  carAllocationSystem.deallocateSlot(car);
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
