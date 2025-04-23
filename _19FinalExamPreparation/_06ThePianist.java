package _19FinalExamPreparation;  // 02. Final Exam Retake
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _06ThePianist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = Integer.parseInt(scanner.nextLine());

        Map<String, PieceClass> pieceMap = new LinkedHashMap<>();

        for (int pos = 0; pos < N; pos++) {

            String[] cmdParts = scanner.nextLine().split("\\|");

            String name = cmdParts[0];
            String composer = cmdParts[1];
            String key = cmdParts[2];

            pieceMap.put(name, new PieceClass(composer, key));
        }

        while (true) {

            String input = scanner.nextLine();

            if (input.equals("Stop")) {
                break;
            }

            String [] commandParts = input.split("\\|");
            String command = commandParts[0];

            switch (command) {

                case "Add":

                    String pieceToAdd = commandParts[1];
                    String composerToAdd = commandParts[2];
                    String keyToAdd = commandParts[3];

                    addPiece(pieceMap, pieceToAdd, composerToAdd, keyToAdd);
                    break;

                case "Remove":

                    String pieceToRemove = commandParts[1];

                    removePiece(pieceMap, pieceToRemove);
                    break;

                case "ChangeKey":

                    String pieceChange = commandParts[1];
                    String newKey = commandParts[2];

                    changeKey(pieceMap, pieceChange, newKey);
                    break;

                default:

                    System.out.println("Invalid command: " + command);
                    break;
            }
        }

        for (Map.Entry<String, PieceClass> entry : pieceMap.entrySet()) {

            System.out.println
                    (entry.getKey() + " -> Composer: " +
                     entry.getValue().composer + ", Key: " +
                     entry.getValue().key);
        }
    }

    public static void addPiece
            (Map<String, PieceClass> piecesMap, String pieceName, String composer, String key) {

        if (piecesMap.containsKey(pieceName)) {

            System.out.println
                    (pieceName + " is already in the collection!");
        }
        else {
            piecesMap.put(pieceName, new PieceClass(composer, key));

            System.out.println
                    (pieceName + " by " + composer + " in " + key + " added to the collection!");
        }
    }

    public static void removePiece
            (Map<String, PieceClass> piecesMap, String pieceName) {

        if (piecesMap.containsKey(pieceName)) {
            piecesMap.remove(pieceName);

            System.out.println
                    ("Successfully removed " + pieceName + "!");
        }
        else {
            System.out.println
                    ("Invalid operation! " + pieceName + " does not exist in the collection.");
        }
    }

    public static void changeKey
            (Map<String, PieceClass> piecesMap, String pieceName, String newKey) {

        if (piecesMap.containsKey(pieceName)) {
            piecesMap.get(pieceName).key = newKey;

            System.out.println
                    ("Changed the key of " + pieceName + " to " + newKey + "!");
        }
        else {
            System.out.println
                    ("Invalid operation! " + pieceName + " does not exist in the collection.");
        }
    }

    static class PieceClass {

        String composer;
        String key;

        public PieceClass(String composer, String key) {

            this.composer = composer;
            this.key = key;
        }
    }
}
