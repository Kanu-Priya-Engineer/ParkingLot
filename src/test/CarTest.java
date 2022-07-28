import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class CarTest {
    private Car car;

    @Before
    public void setUp() throws Exception {
        car = new Car();
    }

    @Test
    public void shouldReturnCarNumber() {

        String expectedCarNumber = "123456";
        car.setCarNumber(expectedCarNumber);

        String actualCarNumber = car.getCarNumber();

        assertThat(actualCarNumber, is(expectedCarNumber));
    }
}
