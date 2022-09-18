import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int C = sc.nextInt();
        int[] array = new int[C];
        int counter = 0;
        for (int i = 0; i < C; i++) {
            array[i] = sc.nextInt();
        }
        for(int i = 0; i < C - 1; i++) {
            for (int j = 0; j < C - i-1; j++) {
                if (array[j] > array[j+1]) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        
        do {
            if (T == 0) {
                break;
            } else if (T >= array[counter]) {
                T -= array[counter];
                counter++;
            } else if (T < array[counter]) {
                break;
            }
        } while (T != 0);
        
        System.out.println(counter);
    }
}
