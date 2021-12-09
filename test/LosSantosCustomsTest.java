import Cars.Saab95;
import Cars.Volvo240;
import Workshops.Workshop;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LosSantosCustomsTest {

    Workshop testWorkshop = new Workshop<>(10);
    Workshop<Saab95> saab95Workshop = new Workshop<>(10);
    Volvo240 testVolvo = new Volvo240();
    Saab95 testSaab = new Saab95();

    @Test
    void load_car_should_be_able_to_load_both_subtypes_of_car(){

        testWorkshop.loadCar(testVolvo);
        testWorkshop.loadCar(testSaab);

        assertEquals(2, testWorkshop.getAmountCars());
    }

}
