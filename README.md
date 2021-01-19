## Driving History Java Project
Probelm Link: https://gist.github.com/dan-manges/1e1854d0704cb9132b74

## Problem Statement

Let's write some code to track driving history for people.

The code will process an input file. You can either choose to accept the input via stdin (e.g. if you're using Ruby `cat input.txt | ruby yourcode.rb`), or as a file name given on the command line (e.g. `ruby yourcode.rb input.txt`). You can use any programming language that you want. Please choose a language that allows you to best demonstrate your programming ability.

Each line in the input file will start with a command. There are two possible commands.

The first command is Driver, which will register a new Driver in the app. Example:

`Driver Dan`

The second command is Trip, which will record a trip attributed to a driver. The line will be space delimited with the following fields: the command (Trip), driver name, start time, stop time, miles driven. Times will be given in the format of hours:minutes. We'll use a 24-hour clock and will assume that drivers never drive past midnight (the start time will always be before the end time). Example:

`Trip Dan 07:15 07:45 17.3`

Discard any trips that average a speed of less than 5 mph or greater than 100 mph.

Generate a report containing each driver with total miles driven and average speed. Sort the output by most miles driven to least. Round miles and miles per hour to the nearest integer.

Example input:

```
Driver Dan
Driver Lauren
Driver Kumi
Trip Dan 07:15 07:45 17.3
Trip Dan 06:12 06:32 21.8
Trip Lauren 12:01 13:16 42.0
```

Expected output:

```
Lauren: 42 miles @ 34 mph
Dan: 39 miles @ 47 mph
Kumi: 0 miles
```
## My Approach: 

### 1. Make a Driver class. 
Since there are several different attributes that can be associated with each driver, I decided to make a Driver class, and each driver instance will have name, distance, speed, time attibutes. In the end, I can sort the drivers based on their distance travelled. 

### 2. Scan and parse the input.txt file. 
I decided to make a Solution class and scan every line (command) in the input.txt file in my storeInput method. I want to parse each command so first thing I did was to split each command by white space, and store it into a array of words, so that I can access different attributes of the Driver by using index of the words array.

### 3. Make a HashMap for drivers and store each trip. 
Because there could be mutiple trips for a driver, I want to have easy access to each Driver instance when I encounter another trip for the same driver. Therefore, I made a HashMap with key = driver.name and value = Driver. For each command, I can then first check if the command is Driver or Trip. If it is a driver command, then I make a new Driver instance and add it to my hashmap, if its a trip command, then I find the driver by name using HashMap, then update the driver's total distance, time, and speed. I also had to make another method in my Driver class speedValid() to check if the speed of this current trip is less than 5 mph or greater than 100 mph. If this trip's speed is valid, then I can update my driver instance. 

### 4. Put the drivers into a list and sort the drivers based on distance. 
Now that I have a hashmap of all the drivers, I can store every driver into a ArrayList. I use a new Comparator based on the driver's travel distance to sort the driver's list by desending order. 

### 5. Print out the drivers. 
Finally I can generate a report of drivers by print them out one by one from the list. 

## My tests 

All my testing files and solution files are under src. I created a testing file for Driver class and a testing file for Solution class. I tested the driver class' every method using two drivers instance. For testing Solution class, I used two input files, one is the example input in problem statement, the other one is a list of commands of three people, with Driver and Trip commands not in order (Trip command can go first before the Driver command). In addition, I made one driver to have no trip, one driver to have a trip that is over speed limit, and another driver to have a trip within the speed limit. 

## Instructions to run your test file at command line:

1. Open terminal on Mac or CMD on windows

2. cd into the directory where you want to clone this project

3. git clone the project under your current directory

5. cd into the project folder and then the src folder 

6. Compile Solution.java file with "javac Solution.java"

7. Run Solution.java file with "java Solution"

5. Follow the prompt at command line to enter the full path of your test file 

6. 👏 Now you should be able to see the drivers' report! 

## Instructions to run my test files at command line:

Same as run the user test files at command line, but compile and replace the filename in step 6 and step 7 with TestDriver and TestSolution. 
