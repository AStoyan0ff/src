package _19FinalExamPreparation; // 03. Fundamentals Final Exam
import java.util.*;

public class _09PlantDiscovery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = Integer.parseInt(scanner.nextLine());
        Map<String, Plant> plantsMap = new LinkedHashMap<>();

        for (int pos = 0; pos < N; pos++) {
            String [] plantParts = scanner.nextLine().split("<->");

            String name = plantParts[0];
            int rarity = Integer.parseInt(plantParts[1]);

            plantsMap.put(name, new Plant(name, rarity));
        }

        String cmd;
        while (!(cmd = scanner.nextLine()).equals("Exhibition")) {
            String [] cmdParts = cmd.split(": ");

            String action = cmdParts[0];
            String [] details = cmdParts[1].split(" - ");

            String plantName = details[0];
            Plant plant = plantsMap.get(plantName);

            if (plant == null) {
                System.out.println("error");
                continue;
            }

            if (action.equals("Rate")) {

                int rating = Integer.parseInt(details[1]);
                plant.addRating(rating);
            }
            else if (action.equals("Update")) {

                int newRarityIndex = Integer.parseInt(details[1]);
                plant.setRarity(newRarityIndex);
            }
            else if (action.equals("Reset")) {
                plant.resetRating();
            }
            else {
                System.out.println("error");
            }
        }
        System.out.println("Plants for the exhibition:");

        for (Plant plant : plantsMap.values()) {
            System.out.printf
                    ("- %s; Rarity: %d; Rating: %.2f%n", plant.getName(), plant.getRarity(), plant.getAvrRating());
        }
    }
}

class Plant {

    private String name;
    private int rarity;
    private List<Integer> ratingList;

    public Plant(String name, int rarity) {

        this.name = name;
        this.rarity = rarity;
        this.ratingList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getRarity() {
        return rarity;
    }

    public void setRarity(int rarity) {
        this.rarity = rarity;
    }

    public void addRating(int rating) {
        ratingList.add(rating);
    }

    public void resetRating() {
        ratingList.clear();
    }

    public double getAvrRating() {

        if (ratingList.isEmpty()) {
            return 0.0;
        }
        int result = 0;
        int count = 0;

        for (Integer rating : ratingList) {

            int intValue = rating.intValue(); // Can used Stream API, Lambda
            result += intValue;
            count++;
        }
        return count > 0 ? (double) result / count : 0.0;
    }
}
