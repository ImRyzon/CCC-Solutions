import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String scan = sc.nextLine();
        String direction = "";
        int parse = 0;
        int sum = 0;

        do {
            if (scan.equals("99999")) {
                break;
            } else {
                parse = Integer.parseInt(String.valueOf(scan.charAt(0)));
                sum += parse;
                parse = Integer.parseInt(String.valueOf(scan.charAt(1)));
                sum += parse;
                if (sum == 0) {
                    System.out.println(direction + " " + scan.substring(2, 5));
                } else if (sum % 2 == 1) {
                    System.out.println("left " + scan.substring(2, 5));
                    direction = "left";
                } else if (sum % 2 == 0) {
                    System.out.println("right " + scan.substring(2, 5));
                    direction = "right";
                }
            }
            scan = sc.nextLine();
            sum = 0;
        } while (!(scan.equals("99999")));
    }
}
