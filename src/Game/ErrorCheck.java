package Game;

import java.util.Scanner;

public class ErrorCheck {

    public static int getInt(Scanner sc) {
        if (sc.hasNextInt()){
            return sc.nextInt();
        } else {
            sc.nextLine();
            System.out.println("Please type in a number from 1-3!");
            return sc.nextInt();
        }
    }
}
