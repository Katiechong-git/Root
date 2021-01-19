import java.util.Objects;

public class Driver {
    String name;
    double distance; // in miles
    double time; // in hours
    int speed; // in mph

    public Driver(String name) {
        this.name = name;
        this.distance = 0;
        this.time = 0;
        this.speed = 0;
    }

    public void setDistance(String strDistance) {
        this.distance += Double.parseDouble(strDistance);
    }

    public void setTime(String startTime, String endTime) {
        String start[] = startTime.split(":");
        String end[] = endTime.split(":");

        double startHour = Double.parseDouble(start[0]) + Double.parseDouble(start[1]) / 60;
        double endHour = Double.parseDouble(end[0]) + Double.parseDouble(end[1]) / 60;

        this.time += endHour - startHour;
    }

    public void setSpeed() {
        this.speed = (int) Math.round(distance/time);
    }

    public int getSpeed() {
        return this.speed;
    }

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
