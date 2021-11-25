import HelperClasses.Direction;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DirectionGetTest {

    //We have to insert the start values as argument since the class doesn't have a constructor.
    Direction testDir = new Direction(0);

    @Test
    void get_direction_should_return_value_0(){
        assertEquals(0, testDir.getDirection());
    }
}
