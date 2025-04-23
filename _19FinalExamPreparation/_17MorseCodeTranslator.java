package _19FinalExamPreparation;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class _17MorseCodeTranslator {

    private static final Map<String, Character> MORSE_MAP = new HashMap<>();

    static {

        MORSE_MAP.put(".-", 'A');
        MORSE_MAP.put("-...", 'B');
        MORSE_MAP.put("-.-.", 'C');
        MORSE_MAP.put("-..", 'D');
        MORSE_MAP.put(".", 'E');
        MORSE_MAP.put("..-.", 'F');
        MORSE_MAP.put("--.", 'G');
        MORSE_MAP.put("....", 'H');
        MORSE_MAP.put("..", 'I');
        MORSE_MAP.put(".---", 'J');
        MORSE_MAP.put("-.-", 'K');
        MORSE_MAP.put(".-..", 'L');
        MORSE_MAP.put("--", 'M');
        MORSE_MAP.put("-.", 'N');
        MORSE_MAP.put("---", 'O');
        MORSE_MAP.put(".--.", 'P');
        MORSE_MAP.put("--.-", 'Q');
        MORSE_MAP.put(".-.", 'R');
        MORSE_MAP.put("...", 'S');
        MORSE_MAP.put("-", 'T');
        MORSE_MAP.put("..-", 'U');
        MORSE_MAP.put("...-", 'V');
        MORSE_MAP.put(".--", 'W');
        MORSE_MAP.put("-..-", 'X');
        MORSE_MAP.put("-.--", 'Y');
        MORSE_MAP.put("--..", 'Z');
    }

    public static String decodeMorse(String morseCode) {


        StringBuilder buffer = new StringBuilder();
        String[] words = morseCode.split(" \\| ");

        for (int pos = 0; pos < words.length; pos++) {
            String[] letters = words[pos].split(" ");

            for (String let : letters) {
                buffer.append(MORSE_MAP.getOrDefault(let, ' '));
            }
            if (pos < words.length - 1) {
                buffer.append(' ');
            }
        }

        return buffer.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        System.out.print(decodeMorse(input));

    }
}
