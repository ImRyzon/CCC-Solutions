import java.util.*;
import java.io.*;
import java.text.*;
public class Senior1 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {

        int N = readInt();
        String[] r1 = readLine().split(" ");
        Integer[] heights = new Integer[r1.length];
        String[] r2 = readLine().split(" ");
        Integer[] widths = new Integer[r2.length];
        double area = 0;

        for (int i = 0; i < r2.length; i++) {
            heights[i] = Integer.parseInt(r1[i]);
            widths[i] = Integer.parseInt(r2[i]);
        }
        heights[N] = Integer.parseInt(r1[N]);

        for (int i = 0; i < N; i++) {
            area += (widths[i] * (heights[i] + heights[i+1])) / 2.0;
        }

        DecimalFormat df = new DecimalFormat("0.#");
        System.out.println(df.format(area));
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
