import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int[] array = new int[3];
        
        for (int i = 0; i < 3; i++) {
            array[i] = sc.nextInt();
        }
        
        if (array[0] + array[1] + array[2] != 180) {
            System.out.println("Error");
        } else if (array[0] == 60 && array[1] == 60 && array[2] == 60) {
            System.out.println("Equilateral");
        } else if (array[0] == array[1] || array[1] == array[2] || array[0] == array[2]) {
            System.out.println("Isosceles");
        } else {
            System.out.println("Scalene");
        }
    }
}
