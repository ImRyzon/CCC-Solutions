import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String line1 = sc.nextLine();
        String line2 = sc.nextLine();
        line1 = line1.replaceAll("\\s+", "");
        line2 = line2.replaceAll("\\s+", "");

        StringBuilder sb1 = new StringBuilder(line1);
        StringBuilder sb2 = new StringBuilder(line2);

        int index = 0;
        char character = ' ';
        String valueof = "";
        boolean isAnagram = true;
        for (int i = 0; i < line2.length()-1; i++) {
            character = sb1.charAt(0);
            valueof = String.valueOf(character);
            index = sb2.indexOf(valueof);

            if (index == -1) {
                isAnagram = false;
                break;
            } else {
                sb1.deleteCharAt(0);
                sb2.deleteCharAt(index);
            }
        }
        
        if (isAnagram == true && (sb1.charAt(0) == sb2.charAt(0))) {
            System.out.println("Is an anagram.");
        } else {
            System.out.println("Is not an anagram.");
        }
    }
}
