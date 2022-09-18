import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        boolean quit = false;
        String word = "";
        String wordSub = "";
        while (!false) {
            word =sc.nextLine();
            int wordLength = word.length();
            
            if (wordLength < 4) {
                System.out.println(word);
            } else if (word.equals("quit!")) {
                quit = true;
                break;
            } else {
                int length = word.length();
                char c = word.charAt(length-3);
                if (c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u' && c != 'y') {
                    if (word.charAt(length-2) == 'o' && word.charAt(length-1) == 'r') {
                        wordSub = word.substring(0, length-1) + "ur";
                        System.out.println(wordSub);
                    } else {
                        System.out.println(word);
                    }
                } else {
                    System.out.println(word);
                }
            }
        }
    }
}
