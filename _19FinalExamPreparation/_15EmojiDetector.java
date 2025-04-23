package _19FinalExamPreparation;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _15EmojiDetector {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        long coolThreshold = 1;

        Pattern digitP = Pattern.compile("\\d");
        Matcher digitM = digitP.matcher(input);

        while (digitM.find()) {
            coolThreshold *= Integer.parseInt(digitM.group());
        }
        System.out.println("Cool threshold: " + coolThreshold);

        Pattern emojiP = Pattern.compile(("(::|\\*\\*)([A-Z][a-z]{2,})\\1"));
        Matcher emojiM = emojiP.matcher(input);

        List<String> bFirstEmojiList = new ArrayList<>();
        List <String> bestEmojiList = new ArrayList<>();

        while (emojiM.find()) {

            String emoji = emojiM.group();
            String emojiName = emojiM.group(2);

            if ( emojiName.matches("[A-Z][a-z]+")) {
                bFirstEmojiList.add(emoji);

                int cool = 0;

                for (char c : emojiName.toCharArray()) {
                    cool += c;
                }

                if (cool >= coolThreshold) {
                    bestEmojiList.add(emoji);
                }
            }
        }
        System.out.println
                (bFirstEmojiList.size() + " emojis found in the text. The cool ones are:");

        for (String best : bestEmojiList) {
            System.out.println(best);
        }
    }
}
