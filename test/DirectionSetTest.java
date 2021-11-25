import HelperClasses.Direction;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DirectionSetTest {

    //We have to insert the start values as argument since the class doesn't have a constructor.
    Direction testDir = new Direction(0);

    @Test
    void get_direction_should_return_value_0(){
        testDir.setDirection(730);
        //We use a value that loops around the circle twice.
        assertEquals(10, testDir.getDirection());
    }
}
