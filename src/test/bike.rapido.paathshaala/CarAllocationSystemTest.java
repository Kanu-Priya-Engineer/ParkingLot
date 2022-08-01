
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;


public class CarAllocationSystemTest {
    CarAllocationSystem carAllocationSystem;

    @Before
    public void setUp() throws Exception {
        carAllocationSystem = new CarAllocationSystem();
    }

    @Test
    public void shouldAllocateSlotForOneCar(){
        String carNumber = "1";
        Car car = new Car(carNumber);

        String actualMessage = carAllocationSystem.allocateSlot(car);

        assertTrue(actualMessage.contains(carNumber));
    }

    @Test
    public void shouldAllocateSlotForTwoCars(){
        String carNumber1 = "1";
        Car car1 = new Car(carNumber1);
        carAllocationSystem.allocateSlot(car1);

        String carNumber2 = "2";
        Car car2 = new Car(carNumber2);

        String actualMessage = carAllocationSystem.allocateSlot(car2);
        assertTrue(actualMessage.contains(carNumber2));

    }
    @Test
    public void shouldNotAllocateSlotForCarAfterParkingSlotIsFull(){
        String carNumber1 = "1";
        Car car1 = new Car(carNumber1);
        carAllocationSystem.allocateSlot(car1);

        String carNumber2 = "2";
        Car car2 = new Car(carNumber2);
        carAllocationSystem.allocateSlot(car2);

        String carNumber3 = "3";
        Car car3 = new Car(carNumber3);

        String expectedMessage = "Sorry! All slots are occupied";
        String actualMessage = carAllocationSystem.allocateSlot(car3);

        assertThat(actualMessage, is(expectedMessage));
    }

    @Test
    public void shouldBeAbleToDeallocateSlotForCarWhichIsAlreadyParked(){
        String carNumber1 = "1";
        Car car1 = new Car(carNumber1);
        carAllocationSystem.allocateSlot(car1);

        String carNumber2 = "2";
        Car car2 = new Car(carNumber2);
        carAllocationSystem.allocateSlot(car2);

        String actualMessage = carAllocationSystem.deallocateSlot(car1);

        assertTrue(actualMessage.contains(carNumber2));
    }

    @Test
    public void shouldNotBeAbleToDeallocateSlotForCarWhichIsNotParked(){
        String carNumber1 = "1";
        Car car1 = new Car(carNumber1);
        carAllocationSystem.allocateSlot(car1);

        String carNumber2 = "2";
        Car car2 = new Car(carNumber2);
        carAllocationSystem.allocateSlot(car2);

        String carNumber3 = "3";
        Car car3 = new Car(carNumber3);

        String expectedMessage = "This car is not parked.";
        String actualMessage = carAllocationSystem.deallocateSlot(car3);

        assertThat(actualMessage, is(expectedMessage));
    }


}
