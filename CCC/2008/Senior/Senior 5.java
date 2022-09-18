import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String args[]) throws IOException{
    	int move[][]= {{2,1,0,2}, {1,1,1,1}, {0,0,2,1},{0,3,0,0}, {1,0,0,1}};
    	boolean [][][][] dp = new boolean[31][31][31][31];
    	for(int a=0; a<31; a++){
    		for(int b =0; b<31; b++) {
    			for(int c =0; c<31; c++) {
    				for(int d=0; d<31; d++) {
    					for(int k=0; k<5; k++) {
    						if(a >= move[k][0] && b >= move[k][1] && c >= move[k][2] && d >= move[k][3]) {
    							if(!dp[a - move[k][0]][b - move[k][1]][c - move[k][2]][d  - move[k][3]]) dp[a][b][c][d]=true;
    						}
    					}
    				}
    			}
    		}
    	}
    	for(int t = readInt(); t > 0; t--) {
    		int a = readInt(), b = readInt(), c = readInt(), d = readInt();
    		System.out.println(dp[a][b][c][d]? "Patrick": "Roland");
    	}
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
