import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class AllocationSystemTest {
    Car car;
    AllocationSystem allocationSystem;


    @BeforeClass
    public static void beforeClass() throws Exception {
        for(int index = 0; index<5; index++){
            ParkingManagementSystem.parkingSlots.add(index, null);
        }
    }

    @Before
    public void setUp() throws Exception {
        car = new Car();
        allocationSystem = new AllocationSystem();

    }

    @Test
    public void shouldAllocateSlotForCar1(){
        String carNumber = "1";
        car.setCarNumber(carNumber);

        String expectedMessage = "Your car parked successfully.";
        String actualMessage = allocationSystem.parkCar(car);

        assertThat(actualMessage, is(expectedMessage));
    }

    @Test
    public void shouldAllocateSlotForCar2(){
        String carNumber = "2";
        car.setCarNumber(carNumber);

        String expectedMessage = "Your car parked successfully.";
        String actualMessage = allocationSystem.parkCar(car);

        assertThat(actualMessage, is(expectedMessage));
    }

    @Test
    public void shouldAllocateSlotForCar3(){
        String carNumber = "3";
        car.setCarNumber(carNumber);

        String expectedMessage = "Your car parked successfully.";
        String actualMessage = allocationSystem.parkCar(car);

        assertThat(actualMessage, is(expectedMessage));
    }

    @Test
    public void shouldAllocateSlotForCar4(){
        String carNumber = "4";
        car.setCarNumber(carNumber);

        String expectedMessage = "Your car parked successfully.";
        String actualMessage = allocationSystem.parkCar(car);

        assertThat(actualMessage, is(expectedMessage));
    }

    @Test
    public void shouldAllocateSlotForCar5(){
        String carNumber = "5";
        car.setCarNumber(carNumber);

        String expectedMessage = "Your car parked successfully.";
        String actualMessage = allocationSystem.parkCar(car);

        assertThat(actualMessage, is(expectedMessage));
    }

    @Test
    public void shouldAllocateSlotForCar6(){
        String carNumber = "6";
        car.setCarNumber(carNumber);

        String expectedMessage = "Sorry! All seats are occupied";
        String actualMessage = allocationSystem.parkCar(car);

        assertThat(actualMessage, is(expectedMessage));
    }

    @Test
    public void shouldNotAllocateSlotForCarAfterParkingSlotIsFull(){
        String carNumber = "7";
        car.setCarNumber(carNumber);

        String expectedMessage = "Sorry! All slots are occupied";
        String actualMessage = allocationSystem.parkCar(car);

        assertThat(actualMessage, is(expectedMessage));
    }

    @Test
    public void shouldDeallocateSlotForCar5(){
        String carNumber = "5";
        car.setCarNumber(carNumber);

        String expectedMessage = "Your car removed successfully.";
        String actualMessage = allocationSystem.removeCar(car);

        assertThat(actualMessage, is(expectedMessage));
    }

    @Test
    public void shouldNotDeallocateSlotForCarWhichNotPresent(){
        String carNumber = "5";
        car.setCarNumber(carNumber);

        String expectedMessage = "This car is not parked.";
        String actualMessage = allocationSystem.removeCar(car);

        assertThat(actualMessage, is(expectedMessage));
    }


}
