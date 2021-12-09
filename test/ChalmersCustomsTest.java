import Cars.Saab95;
import Cars.Volvo240;
import Workshops.Workshop;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChalmersCustomsTest {

    Workshop<Volvo240> testWorkshop = new Workshop<Volvo240>(10);
    Volvo240 testVolvo = new Volvo240();
    Saab95 testSaab = new Saab95();

    @Test
    void load_car_should_load_volvo(){

        testWorkshop.loadCar(testVolvo);

        assertEquals(1, testWorkshop.getAmountCars());
    }

    /* Uncomment to test
    @Test
    void load_car_should_not_load_saab(){

        testWorkshop.loadCar(testSaab);

        assertEquals(0, testWorkshop.getAmountCars());

    } */


}
