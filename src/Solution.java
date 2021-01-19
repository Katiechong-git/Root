import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {
    // store the input text into a hashmap with key = Driver command and values = List of Trip command
    HashMap<String, Driver> hashmap = new HashMap<>();

    /**
     * Store the input text into hashmap, with drivers name as keys and driver objects as values
     * @param fileName
     */
    public void storeInput(String fileName) throws FileNotFoundException {
        URL url = getClass().getResource(fileName);
        File inputFile = new File(url.getPath());

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

                    // update this driver's time and distance
                    existedDriver.setTime(splited[2], splited[3]);
                    existedDriver.setDistance(splited[4]);
                    hashmap.put(name, existedDriver);
                }
                else {
                    // if this driver does not exist then we add this driver to the hashmap
                    Driver newDriver = new Driver(name);
                    newDriver.setTime(splited[2], splited[3]);
                    newDriver.setDistance(splited[4]);
                    hashmap.put(name, newDriver);
                }
            }

            // set the speed for the current driver
            hashmap.get(name).setSpeed();
        }
        scanner.close();

    }

}
