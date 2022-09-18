import java.util.*;
import java.io.*;
public class Junior2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {

        int N = readInt();
        String[] names = new String[N];
        int[] bids = new int[N];

        for (int i = 0; i < N; i++) {
            names[i] = readLine();
            bids[i] = readInt();
        }

        for (int i = 0; i < N-1; i++) {
            for (int j = 0; j < N-1-i; j++) {
                if (bids[j] < bids[j+1]) {

                    String tempName = names[j];
                    int tempBid = bids[j];

                    bids[j] = bids[j+1];
                    names[j] = names[j+1];

                    names[j+1] = tempName;
                    bids[j+1] = tempBid;
                }
            }
        }

        System.out.println(names[0]);

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
