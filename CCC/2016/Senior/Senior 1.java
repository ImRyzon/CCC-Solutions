import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String line1 = sc.nextLine();
        String line2 = sc.nextLine();
        line2 = line2.replaceAll("[^a-z]", "");
        int index = 0;
        boolean isRagaman = true;
        int length = line2.length();

        for (int i = 0; i < length; i++) {
            char character = line2.charAt(0);
            String tostring = String.valueOf(character);
            index = line1.indexOf(tostring);

            if (index == -1) {
                isRagaman = false;
                break;
            } else {
                line1 = line1.replaceFirst(tostring, "");
                line2 = line2.replaceFirst(tostring, "");
            }
        }

        if (isRagaman == true) {
            System.out.println("A");
        } else {
            System.out.println("N");
        }

    }
}
