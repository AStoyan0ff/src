package _08MidRegularExam;
import java.util.Scanner;

public class _01TheBiscuitsFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int biscuits = Integer.parseInt(scanner.nextLine());
        int workers = Integer.parseInt(scanner.nextLine());
        int production = Integer.parseInt(scanner.nextLine());
        int totalBiscuits = resultProduction(biscuits, workers);

        printResults(totalBiscuits, production);
    }

    public static int resultProduction(int biscuitsWorker, int workers) {
        int totalBiscuits = 0;

        for (int pos = 1; pos <= 30; pos++) {
            int productionDay = biscuitsWorker * workers;

            if (pos % 3 == 0) {
                productionDay = (int) Math.floor(productionDay * 0.75);
            }
            totalBiscuits += productionDay;
        }
        return totalBiscuits;
    }

    public static void printResults(int totalBiscuits, int complItems) {
        System.out.println("You have produced " + totalBiscuits + " biscuits for the past month.");

        int diff = totalBiscuits - complItems;
        double percentage = (Math.abs(diff) / (double) complItems) * 100;

        if (totalBiscuits > complItems) {
            System.out.printf("You produce %.2f percent more biscuits.%n", percentage);
        }
        else {
            System.out.printf("You produce %.2f percent less biscuits.%n", percentage);
        }
    }
}

