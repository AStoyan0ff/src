package _19FinalExamPreparation;
import java.util.Scanner;
import java.util.*;

public class _16Pirates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, City> citiesMap = new LinkedHashMap<>();

        String input;
        while (!(input = scanner.nextLine()).equals("Sail")) {
            String [] cityParts = input.split("\\|\\|");

            String name = cityParts[0];
            int population = Integer.parseInt(cityParts[1]);
            int gold = Integer.parseInt(cityParts[2]);

            citiesMap.putIfAbsent(name, new City(name, 0, 0));
            City city = citiesMap.get(name);
            city.addPeople(population);
            city.addGold(gold);
        }

        while (!(input = scanner.nextLine()).equals("End")) {
            String [] dataParts = input.split("=>");

            String even = dataParts[0];
            String town = dataParts[1];

            City city = citiesMap.get(town);

            switch (even) {

                case "Plunder":

                    int people = Integer.parseInt(dataParts[2]);
                    int gold = Integer.parseInt(dataParts[3]);

                    city.robbery(people, gold);

                    if (city.getPopulation() <= 0 || city.getGold() <= 0) {
                        citiesMap.remove(town);

                        System.out.printf
                                ("%s has been wiped off the map!%n", town);
                    }
                    break;

                case "Prosper":

                    int goldAdded = Integer.parseInt(dataParts[2]);
                    city.arrive(goldAdded);
                    break;
            }
        }

        if (citiesMap.isEmpty()) {
            System.out.println
                    ("Ahoy, Captain! All targets have been plundered and destroyed!");
        }
        else {
            System.out.printf
                    ("Ahoy, Captain! There are %d wealthy settlements to go to:%n", citiesMap.size());

            for (City city : citiesMap.values()) {
                System.out.println(city);
            }
        }
    }
}

class City {

    private String name;
    private int population;
    private int gold;

    public City(String name, int population, int gold) {

        this.name = name;
        this.population = population;
        this.gold = gold;
    }

    public String getName() {
        return name;
    }

    public int getPopulation() {
        return population;
    }

    public int getGold() {
        return gold;
    }

    public void addPeople(int population) {
        this.population += population;
    }

    public  void addGold(int gold) {
        this.gold += gold;
    }

    public void robbery(int people, int gold) {
        this.population -= people;
        this.gold -= gold;

        System.out.printf
                ("%s plundered! %d gold stolen, %d citizens killed.%n", name, gold, people);

    }

    public void arrive(int goldAdded) {

        if (goldAdded < 0) {
            System.out.println("Gold added cannot be a negative number!");
        }
        else {
            this.gold += goldAdded;

            System.out.printf
                    ("%d gold added to the city treasury. %s now has %d gold.%n", goldAdded, name, this.gold);
        }
    }

    @Override
    public String toString() {
        return String.format
                ("%s -> Population: %d citizens, Gold: %d kg", name, population, gold);
    }
}
