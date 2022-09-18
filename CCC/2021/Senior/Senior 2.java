import java.util.*;
import java.io.*;
public class ModernArt {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        int m = readInt(), n = readInt(), k = readInt(), gold = 0;
        int row[] = new int[m], column[] = new int[n];
        for (int i = 0; i < k; i++) {
            char rc = readCharacter(); int pos = readInt();
            if (rc == 'R') {row[pos-1]++;} else {column[pos-1]++;}
        }
        for (int i = 0; i < m; i++) {for (int j = 0; j < n; j++) {if ((row[i] + column[j]) % 2 == 1) gold++;}}
        System.out.println(gold);
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
