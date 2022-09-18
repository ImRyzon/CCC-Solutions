import java.io.*;
import java.util.*;

public class Main {
     public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();
            String[] array = line.split(" ");
            for (int j = 0; j < array.length; j++) {
                if (array[j].length() == 4) {
                    array[j] = "****";
                }
            }
            String tostring = Arrays.toString(array);
            tostring = tostring.replaceAll("[^a-zA-Z,*]", "");
            tostring = tostring.replaceAll(",", " ");
            System.out.println(tostring);
        }
    }
