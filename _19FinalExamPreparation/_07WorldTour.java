package _19FinalExamPreparation; // 03. Final Exam Retake
import java.util.Scanner;

public class _07WorldTour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String stopS = scanner.nextLine(); // Спирки

        String cmd;
        while (!(cmd = scanner.nextLine()).equals("Travel")) {
            stopS = processCmd(stopS, cmd);

            System.out.println(stopS);
        }

        System.out.println("Ready for world tour! Planned stops: " + stopS);
        scanner.close();
    }

    private static String processCmd(String stopS, String cmd) {

        String [] cmdParts = cmd.split(":");
        String action = cmdParts[0];

        switch (action) {

            case "Add Stop":

                int idx = Integer.parseInt(cmdParts[1]);
                String newStr = cmdParts[2];

                stopS = addStop(stopS, idx, newStr);
                break;

            case "Remove Stop":

                int start = Integer.parseInt(cmdParts[1]);
                int end = Integer.parseInt(cmdParts[2]);

                stopS = removeStop(stopS, start, end);
                break;

            case "Switch":

                String oldStr = cmdParts[1];
                String replace = cmdParts[2];

                stopS = switchStop(stopS, oldStr, replace);
                break;
        }
        return stopS;
    }

    private static String addStop(String stopS, int idx, String newStr) {

        if (idx >= 0 && idx <= stopS.length()) {

            StringBuilder buffer = new StringBuilder(stopS);
            buffer.insert(idx, newStr);
            return buffer.toString();
        }
        return stopS;
    }

    private static String removeStop(String stopS, int start, int end) {

        if (start >= 0 && end < stopS.length() && start <= end) {

            StringBuilder buffer = new StringBuilder(stopS);
            buffer.delete(start, end + 1);
            return buffer.toString();
        }
        return stopS;
    }

    private static String switchStop(String stopS, String oldStr, String newStr) {

        if (stopS.contains(oldStr)) {
            return stopS.replace(oldStr, newStr);
        }
        return stopS;
    }
}
