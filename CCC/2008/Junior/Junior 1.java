import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double weight = sc.nextDouble();
        double height = sc.nextDouble();
        double calc = weight / (height*height);
        
        if (calc < 18.5) {
            System.out.println("Underweight");
        } else if (calc <= 25.0) {
            System.out.println("Normal weight");
        } else {
            System.out.println("Overweight");
        }
    }
}
