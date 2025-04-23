package _20ExamPre.Lectures;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _04NeedForSpeed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = Integer.parseInt(scanner.nextLine());
        Map<String, Integer> mileageMap = new LinkedHashMap<>();
        Map<String, Integer> fuelMap = new LinkedHashMap<>();

        for (int i = 0; i < N; i++) {

            String[] carData = scanner.nextLine().split("\\|");

            String carName = carData[0];
            int mileage = Integer.parseInt(carData[1]);
            int fuel = Integer.parseInt(carData[2]);

            mileageMap.put(carName, mileage);
            fuelMap.put(carName, fuel);
        }

        String input;
        while (!(input = scanner.nextLine()).equals("Stop")) {
            String[] cmdParts = input.split(" : ");

            String cmd = cmdParts[0];
            String carName = cmdParts[1];

            if (cmd.equals("Drive")) {

                int distance = Integer.parseInt(cmdParts[2]);
                int fuelNeeded = Integer.parseInt(cmdParts[3]);

                driveCar(mileageMap, fuelMap, carName, distance, fuelNeeded);
            }
            else if (cmd.equals("Refuel")) {
                int fuelAmount = Integer.parseInt(cmdParts[2]);

                refuelCar(fuelMap, carName, fuelAmount);
            }
            else if (cmd.equals("Revert")) {
                int kilometers = Integer.parseInt(cmdParts[2]);

                revertMileage(mileageMap, carName, kilometers);
            }
        }

        printCars(mileageMap, fuelMap);
        scanner.close();
    }

    public static void driveCar(Map<String, Integer> mileageMap, Map<String, Integer> fuelMap, String carName, int distance, int fuelNeeded) {

        if (fuelNeeded > fuelMap.get(carName)) {
            System.out.println
                    ("Not enough fuel to make that ride");
        }
        else {
            mileageMap.put(carName, mileageMap.get(carName) + distance);
            fuelMap.put(carName, fuelMap.get(carName) - fuelNeeded);

            System.out.println
                    (carName + " driven for " + distance + " kilometers. " + fuelNeeded + " liters of fuel consumed.");

            if (mileageMap.get(carName) >= 100000) {

                System.out.println
                        ("Time to sell the " + carName + "!");

                mileageMap.remove(carName);
                fuelMap.remove(carName);
            }
        }
    }

    public static void refuelCar(Map<String, Integer> fuelMap, String carName, int fuelAmount) {

        int currentFuel = fuelMap.get(carName);
        int newFuel = Math.min(currentFuel + fuelAmount, 75);

        System.out.println
                (carName + " refueled with " + (newFuel - currentFuel) + " liters");

        fuelMap.put(carName, newFuel);
    }

    public static void revertMileage(Map<String, Integer> mileageMap, String carName, int kilometers) {

        int currentMileage = mileageMap.get(carName);

        if (currentMileage - kilometers < 10000) {
            mileageMap.put(carName, 10000);
        }
        else {
            mileageMap.put(carName, currentMileage - kilometers);
            System.out.println(carName + " mileage decreased by " + kilometers + " kilometers");
        }
    }

    public static void printCars(Map<String, Integer> mileageMap, Map<String, Integer> fuelMap) {

        for (String car : mileageMap.keySet()) {
            System.out.println
                    (car + " -> Mileage: " + mileageMap.get(car) + " kms, Fuel in the tank: " + fuelMap.get(car) + " lt.");
        }
    }
}
