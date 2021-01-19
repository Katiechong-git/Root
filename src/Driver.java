public class Driver {
    String name;
    double distance; // in miles
    double time; // in hours
    int speed; // in mph

    public Driver(String name) {
        this.name = name;
        distance = 0;
        time = 0;
    }

    public void setDistance(String strDistance) {
        distance += Double.parseDouble(strDistance);
    }

    public void setTime(String startTime, String endTime) {
        String start[] = startTime.split(":");
        String end[] = endTime.split(":");

        double startHour = Double.parseDouble(start[0]) + Double.parseDouble(start[1]) / 60;
        double endHour = Double.parseDouble(end[0]) + Double.parseDouble(end[1]) / 60;

        time += endHour - startHour;
    }

    public int getSpeed() {
        speed = (int) Math.round(distance/time);
        return speed;
    }
}
