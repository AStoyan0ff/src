package _06List.Exercise;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _03HouseParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> guestHouse = new ArrayList<>();
        int cntCmd = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < cntCmd; i++) {

            String cmd = scanner.nextLine();
            String nameGuest = cmd.split(" ")[0];

            if (cmd.contains("is not going!")) {

                if (guestHouse.contains(nameGuest)) {
                    guestHouse.remove(nameGuest);
                }
                else {
                    System.out.println(nameGuest + " is not in the list!");
                }
            }
            else if (guestHouse.contains(nameGuest)) {
                System.out.println(nameGuest + " is already in the list!");
            }
            else {
                guestHouse.add(nameGuest);
            }
        }

        for (String name : guestHouse) {
            System.out.println(name);
        }

        scanner.close();
    }
}
