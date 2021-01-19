import org.junit.jupiter.api.Test;
import static org.junit.*;
import java.io.FileNotFoundException;
import java.util.HashMap;

public class Tests {
    @Test
    public void testStoreInput() throws FileNotFoundException {
        Solution solution1 = new Solution();
        solution1.storeInput("input1.txt");

        HashMap<String, Driver> hashmap1 = new HashMap<>();
        Driver Lauren = new Driver("Lauren");
        Lauren.distance = 42;
        Lauren.speed = 34;
        Lauren.time = 1.25;
        Driver Dan = new Driver("Dan");
        Dan.distance = 42;
        Dan.speed = 34;
        Dan.time = 1.25;
        Driver Kumi = new Driver("Kumi");
        Kumi.distance = 42;
        Kumi.speed = 34;
        Kumi.time = 1.25;

        assertEquals
    }


}
