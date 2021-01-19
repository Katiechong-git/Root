import org.junit.jupiter.api.Test;
import java.io.FileNotFoundException;
import java.util.HashMap;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Tests {
    @Test
    public void testStoreInput() throws FileNotFoundException {
        Solution solution1 = new Solution();
        solution1.storeInput("input1.txt");

        Driver Lauren = new Driver("Lauren");
        Lauren.distance = 42;
        Lauren.speed = 34;
        Lauren.time = 1.25;
        Driver Dan = new Driver("Dan");
        Dan.distance = 39.1;
        Dan.speed = 47;
        Dan.time = 0.833333333333333;
        Driver Kumi = new Driver("Kumi");
        Kumi.distance = 0;
        Kumi.speed = 0;
        Kumi.time = 0;

        HashMap<String, Driver> hashmap1 = new HashMap<>();
        hashmap1.put("Lauren", Lauren);
        hashmap1.put("Dan", Dan);
        hashmap1.put("Kumi", Kumi);

        // expected, actual
        assertEquals(hashmap1, solution1.hashmap);


        Solution solution2 = new Solution();
        solution2.storeInput("input2.txt");

        Driver Minsu = new Driver("Minsu");
        Minsu.distance = 100;
        Minsu.speed = 200;
        Minsu.time = 0.5;
        Driver Arthur = new Driver("Arthur");
        Arthur.distance = 30;
        Arthur.speed = 60;
        Arthur.time = 0.5;
        Driver Brian = new Driver("Brian");
        Brian.distance = 0;
        Brian.speed = 0;
        Brian.time = 0;

        HashMap<String, Driver> hashmap2 = new HashMap<>();
        hashmap2.put("Arthur", Arthur);
        hashmap2.put("Minsu", Minsu);
        hashmap2.put("Brian", Brian);

        // expected, actual
        assertEquals(hashmap2, solution2.hashmap);
    }


}
