import java.util.*;
import java.io.*;
import java.math.*;
public class homework {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
    	int R = readInt(), C = readInt(), a[] = new int[R];
    	for(int i=0; i<R; i++) {
    		for(int j=0; j<C; j++) {
    			a[i] = a[i]<<1 | readInt();  
    		}
    	}
    	Set<Integer> pattern[] = new HashSet[R];
    	for(int i=0; i<R; i++) pattern[i] = new HashSet();
    	pattern[0].add(a[0]);
    	for(int i=1; i<R; i++) {
    		pattern[i].add(a[i]);
    		for(int x: pattern[i-1]) pattern[i].add(a[i] ^ x);
    	}
    	System.out.println(pattern[R-1].size());
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
