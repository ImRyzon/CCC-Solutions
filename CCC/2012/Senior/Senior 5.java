import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String args[]) throws IOException{
    	int R = readInt(), C = readInt(); boolean cat[][] = new boolean[R+1][C+1];
    	int K = readInt();
    	for(int i=1; i<=K; i++) cat[readInt()][readInt()] = true;
    	int dp[][] = new int[R+1][C+1]; dp[0][1] = 1;
    	for(int i=1; i<=R; i++) {
    		for(int j=1; j<=C; j++) {
    			if(cat[i][j]) dp[i][j]= 0;
    			else dp[i][j] = dp[i-1][j] + dp[i][j-1];
    		}
    	}
    	System.out.println(dp[R][C]);
    }
    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }

    static long readLong() throws IOException {
        return Long.parseLong(next());
    }

    static int readInt() throws IOException {
        return Integer.parseInt(next());
    }
    static double readDouble() throws IOException {
        return Double.parseDouble(next());
    }
    static String readLine() throws IOException {
        return br.readLine().trim();
    }
}
