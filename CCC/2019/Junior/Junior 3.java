import java.util.*;
import java.io.*;
public class BufferedTemplate {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = readInt();
        for (int i = 0; i < n; i++) {
            String s = readLine(); int counter = 1;
            if (s.length() == 1) {pr.println(1 + " " + s); continue;}
            for (int j = 1; j < s.length(); j++) {
                if (s.charAt(j) == s.charAt(j-1)) {counter++;}
                else {pr.print(counter + " " + s.charAt(j-1) + " "); counter = 1;}
                if (j == s.length()-1) pr.print(counter + " " + s.charAt(j));
            }
            pr.println("");
        }
        pr.flush();
    }

    static long readLong () throws IOException {return Long.parseLong(next());}
    static int readInt () throws IOException {return Integer.parseInt(next());}
    static double readDouble () throws IOException {return Double.parseDouble(next());}
    static char readCharacter () throws IOException {return next().charAt(0);}
    static String readLine () throws IOException {return br.readLine().trim();}
    static String next () throws IOException {
        while (st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }
}
