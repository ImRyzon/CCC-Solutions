import java.util.*;
import java.io.*;
public class Junior1 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        int sumA = 0;
        int sumB = 0;
        sumA += 3*readInt();
        sumA += 2*readInt();
        sumA += readInt();
        sumB += 3*readInt();
        sumB += 2*readInt();
        sumB += readInt();
        if (sumA > sumB) {
            System.out.println("A");
        } else if (sumA < sumB) {
            System.out.println("B");
        } else {
            System.out.println("T");
        }
    }
    static String next () throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }
    static long readLong () throws IOException {
        return Long.parseLong(next());
    }
    static int readInt () throws IOException {
        return Integer.parseInt(next());
    }
    static double readDouble () throws IOException {
        return Double.parseDouble(next());
    }
    static char readCharacter () throws IOException {
        return next().charAt(0);
    }
    static String readLine () throws IOException {
        return br.readLine().trim();
    }
}
