import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] line = sc.nextLine().split(" ");
        String city = line[0];
        int temp = Integer.parseInt(line[1]);
        while (!(line[0].equalsIgnoreCase("Waterloo"))) {
            line = sc.nextLine().split(" ");
            if (Integer.parseInt(line[1]) < temp) {
                city = line[0];
                temp = Integer.parseInt(line[1]);
            }
            if (line[0].equalsIgnoreCase("Waterloo")) {
                break;
            }
        }
        System.out.println(city);
        sc.close();
    }
}
