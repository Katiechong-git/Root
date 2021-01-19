import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDriver {
    Driver driver1 = new Driver("driver1");
    Driver driver2 = new Driver("driver2");

    @Test
    public void testSetDistance() {
        driver1.setDistance("24.6");
        driver1.setDistance("32.8");
        driver2.setDistance("2.5");
        driver2.setDistance("1.3");
        assertEquals(57.4, driver1.getDistance());
        assertEquals(3.8, driver2.getDistance());
    }

    @Test
    public void testSetTime() {
        driver1.setTime("4:20", "5:00");
        driver1.setTime("8:51", "9:01");
        driver2.setTime("7:00", "8:00");
        assertEquals(0.8333333333333348, driver1.getTime());
        assertEquals(1, driver2.getTime());
    }

    @Test
    public void testSetSpeed() {
        driver1.setDistance("24.6");
        driver1.setDistance("32.8");
        driver2.setDistance("2.5");
        driver2.setDistance("1.3");
        driver1.setTime("4:20", "5:00");
        driver1.setTime("8:51", "9:01");
        driver2.setTime("7:00", "8:00");

        driver1.setSpeed();
        driver2.setSpeed();
        assertEquals(69, driver1.getSpeed());
        assertEquals(4, driver2.getSpeed());
    }

    @Test
    public void testSpeedValid() {
        assertEquals(true, driver1.speedValid("4:20", "5:00", "24.6"));
        // over 100 mph
        assertEquals(false, driver1.speedValid("8:51", "9:01", "32.8"));
        // less than 5 mph
        assertEquals(false, driver2.speedValid("7:00", "8:00", "1.3"));
    }

    @Test
    public void testEquals() {
        assertEquals(false, driver2.equals(driver1));

        Driver driver3 = new Driver("driver");
        Driver driver4 = new Driver("driver");
        assertEquals(true, driver3.equals(driver4));

        driver3.setDistance("100");
        driver3.setTime("12:00", "13:00");
        driver3.setSpeed();
        driver4.setDistance("50");
        driver4.setTime("9:00", "9:30");
        driver4.setDistance("50");
        driver4.setTime("9:00", "9:30");
        driver4.setSpeed();
        assertEquals(true, driver3.equals(driver4));
    }
}
