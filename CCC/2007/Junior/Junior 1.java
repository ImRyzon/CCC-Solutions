import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = new int[3];
        
        for (int i = 0; i < 3; i++) {
            nums[i] = sc.nextInt();
        }
        
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2-i; j++) {
                if (nums[j] > nums[j+1]) {
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
        
        System.out.println(nums[1]);
    }
}
