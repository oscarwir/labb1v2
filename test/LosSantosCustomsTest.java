import Cars.Car;
import java.util.ArrayList;

import Cars.Saab95;
import Cars.Volvo240;
import Workshops.LosSantosCustoms;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LosSantosCustomsTest {

    LosSantosCustomsTest testWorkshop = new LosSantosCustomsTest();
    Volvo240 testVolvo = new Volvo240();
    Saab95 testSaab = new Saab95();

    @Test
    void load_car_should_be_able_to_load_both_subtypes_of_car(){

        testWorkshop.loadCar(testVolvo);
        testWorkshop.loadCar(testSaab);

        assertEquals(2, testWorkshop.getAmountCars());
    }
}
