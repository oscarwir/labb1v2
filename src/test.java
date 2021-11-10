
// Old test file without JUnit
// This isn't used

public class test {
    public static void main(String[] args){
        Saab95 min_fina_saab = new Saab95();
        Volvo240 min_fina_volvo = new Volvo240();

        test_increment_speed(min_fina_saab);

    }

    static void test_increment_speed(Saab95 saab){
        System.out.println(saab.getCurrentSpeed());
        saab.incrementSpeed(20);
        System.out.println(saab.getCurrentSpeed());
        saab.decrementSpeed(20);
        System.out.println(saab.getCurrentSpeed());
    }

    static void test_decrement_speed(){

    }

    static void test_turn_left(){

    }

    static void test_turn_right(){

    }

}
