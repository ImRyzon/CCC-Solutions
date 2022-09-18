import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int age1 = sc.nextInt();
        int age2 = sc.nextInt();
        
        int difference = age2-age1;
        int age3 = age2+difference;
        System.out.println(age3);
    }
}
