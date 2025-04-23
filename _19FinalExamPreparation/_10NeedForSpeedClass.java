package _19FinalExamPreparation;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

class _10NeedForSpeed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = Integer.parseInt(scanner.nextLine());
        Map<String, Car> cars = new LinkedHashMap<>();

        for (int pos = 0; pos < N; pos++) {

            String[] carData = scanner.nextLine().split("\\|");

            String carName = carData[0];
            int mileage = Integer.parseInt(carData[1]);
            int fuel = Integer.parseInt(carData[2]);

            cars.put(carName, new Car(carName, mileage, fuel));
        }

        String input;
        while (!(input = scanner.nextLine()).equals("Stop")) {
            String[] cmdParts = input.split(" : ");

            String cmd = cmdParts[0];
            String carName = cmdParts[1];

            Car car = cars.get(carName);

            switch (cmd) {

                case "Drive":

                    int distance = Integer.parseInt(cmdParts[2]);
                    int fuelNeeded = Integer.parseInt(cmdParts[3]);

                    car.drive(distance, fuelNeeded);

                    if (car.getMileage() >= 100000) {
                        System.out.println("Time to sell the " + car.getName() + "!");

                        cars.remove(carName);
                    }
                    break;

                case "Refuel":

                    int fuelAmount = Integer.parseInt(cmdParts[2]);
                    car.refuel(fuelAmount);

                    break;

                case "Revert":

                    int kilometers = Integer.parseInt(cmdParts[2]);
                    car.revert(kilometers);

                    break;
            }
        }

        for (Car car : cars.values()) {
            System.out.println(car);
        }

        scanner.close();
    }
}

class Car {

    private String name;
    private int mileage;
    private int fuel;

    public Car(String name, int mileage, int fuel) {

        this.name = name;
        this.mileage = mileage;
        this.fuel = fuel;
    }

    public String getName() {
        return name;
    }

    public int getMileage() {
        return mileage;
    }

    public int getFuel() {
        return fuel;
    }

    public void drive(int distance, int fuelNeeded) {

        if (fuelNeeded > fuel) {
            System.out.println("Not enough fuel to make that ride");

            return;
        }

        mileage += distance;
        fuel -= fuelNeeded;

        System.out.println
                (name + " driven for " + distance + " kilometers. " + fuelNeeded + " liters of fuel consumed.");
    }

    public void refuel(int fuelAmount) {

        int fuelAdded = Math.min(fuelAmount, 75 - fuel);
        fuel += fuelAdded;

        System.out.println
                (name + " refueled with " + fuelAdded + " liters");
    }

    public void revert(int kilometers) {

        mileage -= kilometers;

        if (mileage < 10000) {
            mileage = 10000;
        }
        else {
            System.out.println
                    (name + " mileage decreased by " + kilometers + " kilometers");
        }
    }

    @Override
    public String toString() {
        return name + " -> Mileage: " + mileage + " kms, Fuel in the tank: " + fuel + " lt.";
    }
}