import java.util.Objects;

public class Driver {
    String name;
    double distance; // in miles
    double time; // in hours
    int speed; // in mph

    /**
     * Constructor for Driver class
     * @param name
     */
    public Driver(String name) {
        this.name = name;
        this.distance = 0;
        this.time = 0;
        this.speed = 0;
    }

    /**
     * get the name of the driver
     * @return String name
     */
    public String getName() {
        return this.name;
    }

    /**
     * set the distance
     * @param strDistance
     */
    public void setDistance(String strDistance) {
        this.distance += Double.parseDouble(strDistance);
    }

    /**
     * Get the distance so far
     * @return double distance
     */
    public double getDistance() {
        return this.distance;
    }


    /**
     * Set the time
     * @param startTime
     * @param endTime
     */
    public void setTime(String startTime, String endTime) {
        String start[] = startTime.split(":");
        String end[] = endTime.split(":");

        double startHour = Double.parseDouble(start[0]) + Double.parseDouble(start[1]) / 60;
        double endHour = Double.parseDouble(end[0]) + Double.parseDouble(end[1]) / 60;

        this.time += endHour - startHour;
    }

    /**
     * Get the time driving so far
     * @return double time
     */
    public double getTime() {
        return this.time;
    }

    /**
     * Check if the speed of this trip is valid
     * @param startTime
     * @param endTime
     * @return true if 5 <= speed <= 100, false otherwise
     */
    public boolean speedValid(String startTime, String endTime, String strDistance) {
        String start[] = startTime.split(":");
        String end[] = endTime.split(":");

        double startHour = Double.parseDouble(start[0]) + Double.parseDouble(start[1]) / 60;
        double endHour = Double.parseDouble(end[0]) + Double.parseDouble(end[1]) / 60;

        double tripTime = endHour - startHour;
        double tripDistance = Double.parseDouble(strDistance);
        int tripSpeed = (int) Math.round(tripDistance/tripTime);

        return (tripSpeed >= 5 && tripSpeed <= 100);
    }

    /**
     * Set the speed
     */
    public void setSpeed() {
        this.speed = (int) Math.round(distance/time);
    }

    /**
     * Get the driver's average speed
     * @return speed
     */
    public int getSpeed() {
        return this.speed;
    }

    /**
     * override the .equals method for object class
     * @param o
     * @return true if name, speed, distance and time all equals, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Driver driver = (Driver) o;
        return Double.compare(driver.distance, distance) == 0 &&
                Double.compare(driver.time, time) == 0 &&
                speed == driver.speed &&
                name.equals(driver.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, distance, time, speed);
    }
}
