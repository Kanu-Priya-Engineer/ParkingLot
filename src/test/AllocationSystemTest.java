import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class AllocationSystemTest {
    AllocationSystem allocationSystem;

    @BeforeClass
    public static void beforeClass() throws Exception {
        for(int index = 0; index<2; index++){
            ParkingManagementSystem.parkingSlots.add(index, null);
        }
        ParkingManagementSystem.availableSpace=2;
    }

    @Before
    public void setUp() throws Exception {
        allocationSystem = new AllocationSystem();
        for(int index = 0; index<2; index++){
            ParkingManagementSystem.parkingSlots.set(index, null);
        }
        ParkingManagementSystem.availableSpace=2;
    }

    @Test
    public void shouldAllocateSlotForCar1(){
        String carNumber = "1";
        Car car = new Car(carNumber);

        String expectedSlotNumber = "1";
        String expectedMessage = "Your car parked successfully at Slot : " + expectedSlotNumber;
        String actualMessage = allocationSystem.parkCar(car);

        assertThat(actualMessage, is(expectedMessage));
    }

    @Test
    public void shouldAllocateSlotForCar2(){
        String carNumber1 = "1";
        Car car1 = new Car(carNumber1);
        allocationSystem.parkCar(car1);

        String carNumber2 = "2";
        Car car2 = new Car(carNumber2);

        String expectedSlotNumber = "2";
        String expectedMessage = "Your car parked successfully at Slot : " + expectedSlotNumber;
        String actualMessage = allocationSystem.parkCar(car2);

        assertThat(actualMessage, is(expectedMessage));
    }
    @Test
    public void shouldNotAllocateSlotForCarAfterParkingSlotIsFull(){
        String carNumber1 = "1";
        Car car1 = new Car(carNumber1);
        allocationSystem.parkCar(car1);

        String carNumber2 = "2";
        Car car2 = new Car(carNumber2);
        allocationSystem.parkCar(car2);

        String carNumber3 = "3";
        Car car3 = new Car(carNumber3);

        String expectedMessage = "Sorry! All slots are occupied";
        String actualMessage = allocationSystem.parkCar(car3);

        assertThat(actualMessage, is(expectedMessage));
    }

    @Test
    public void shouldDeallocateSlotForCarWhichIsParked(){
        String carNumber1 = "1";
        Car car1 = new Car(carNumber1);
        allocationSystem.parkCar(car1);

        String carNumber2 = "2";
        Car car2 = new Car(carNumber2);
        allocationSystem.parkCar(car2);

        String actualMessage = allocationSystem.removeCar(car1);
        String expectedSlotNumber = "1";
        String expectedMessage = "Your car removed successfully from Slot : " + expectedSlotNumber;

        assertThat(actualMessage, is(expectedMessage));
    }

    @Test
    public void shouldNotDeallocateSlotForCarWhichIsNotParked(){
        String carNumber1 = "1";
        Car car1 = new Car(carNumber1);
        allocationSystem.parkCar(car1);

        String carNumber2 = "2";
        Car car2 = new Car(carNumber2);
        allocationSystem.parkCar(car2);

        String carNumber3 = "3";
        Car car3 = new Car(carNumber3);

        String expectedMessage = "This car is not parked.";
        String actualMessage = allocationSystem.removeCar(car3);

        assertThat(actualMessage, is(expectedMessage));
    }


}
