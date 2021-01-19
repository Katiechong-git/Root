import java.io.File;
import java.io.FileNotFoundException;
//import java.net.URL;
import java.util.*;

public class Solution {
    // store the input text into a hashmap with key = Driver command and values = List of Trip command
    HashMap<String, Driver> hashmap = new HashMap<>();
    List<Driver> driversList = new ArrayList<>();

    /**
     * Store the input text into hashmap, with drivers name as keys and driver objects as values
     * @param filePath
     */
    public void storeInput(String filePath) throws FileNotFoundException {
//        URL url = getClass().getResource(fileName);
        File inputFile = new File(filePath);

        Scanner scanner = new Scanner(inputFile);
        while (scanner.hasNextLine()) {
            String command = scanner.nextLine();
            // split the command input by space as delimiter
            String[] splited = command.split("\\s+");
            String name = splited[1];;

            // put driver name into hashmap as key
            if (splited[0].equals("Driver")) {
                // put this driver into hashmap if this diver does not exist yet
                if (!hashmap.containsKey(name)) {
                    hashmap.put(name, new Driver(name));
                }
            }
            // put this trip details into driver object in hashmap
            else if (splited[0].equals("Trip")) {
                if (hashmap.containsKey(name)) {
                    Driver existedDriver = hashmap.get(name);

                    // if this trip's speed is valid for this driver
                    if (existedDriver.speedValid(splited[2], splited[3], splited[4])) {
                        // update this driver's time and distance
                        existedDriver.setTime(splited[2], splited[3]);
                        existedDriver.setDistance(splited[4]);
                        existedDriver.setSpeed();
                    }
                }
                else {
                    // if this driver does not exist then we add this driver to the hashmap
                    Driver newDriver = new Driver(name);
                    hashmap.put(name, newDriver);

                    // if this trip's speed is valid for this driver
                    if (newDriver.speedValid(splited[2], splited[3], splited[4])) {
                        newDriver.setTime(splited[2], splited[3]);
                        newDriver.setDistance(splited[4]);
                        newDriver.setSpeed();
                    }
                }
            }
        }
        scanner.close();
    }

    /**
     * Storing all the drivers from the hashmap to driver's list and sort them by desending order of distance traveled
     * @return List<Driver>
     */
    public List<Driver> sortDrivers() {
        for (String name : hashmap.keySet()) {
            Driver driver = hashmap.get(name);
            driversList.add(driver);
        }

        Collections.sort(driversList, new Comparator<Driver>() {
            @Override
            public int compare(Driver o1, Driver o2) {
                return (int) (o2.getDistance() - o1.getDistance());
            }
        });
        return driversList;
    }

    /**
     * Generate report on the list of drivers
     * example format: "Lauren: 42 miles @ 34 mph"
     */
    public void printDrivers() {
        for (Driver driver : driversList) {
            System.out.println(driver.getName() + ": " + (int) Math.round(driver.getDistance()) + " miles @ " + driver.getSpeed() + " mph");
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter full path for test file");
        String filePath = scanner.nextLine();  // Read user input

        Solution solution = new Solution();
        solution.storeInput(filePath);
        solution.sortDrivers();
        solution.printDrivers();
    }
}
