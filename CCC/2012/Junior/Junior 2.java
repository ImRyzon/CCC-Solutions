import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = new int[4];

        for (int i = 0; i < 4; i++) {
            nums[i] = sc.nextInt();
        }

        if (nums[0] > nums[1] && nums[1] > nums[2] && nums[2] > nums[3]) {
            System.out.println("Fish Diving");
        } else if (nums[0] < nums[1] && nums[1] < nums[2] && nums[2] < nums[3]) {
            System.out.println("Fish Rising");
        } else if (nums[0] == nums[1] && nums[1] == nums[2] && nums[2] == nums[3]) {
            System.out.println("Fish At Constant Depth");
        } else {
            System.out.println("No Fish");
        }
    }
}
