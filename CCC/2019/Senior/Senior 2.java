import java.util.*;
import java.io.*;
public class homework {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		for(int T = readInt(); T > 0; T--) {
			int n = readInt();
			for(int a = 3; a <= n; a += 2) {
				if(isPrime(a) && isPrime(2*n - a)) {
					System.out.println(a + " " + (2*n-a));
					break;
				}
			}
		}
	}
	static boolean isPrime(int n) {
		if(n < 2) return false;
		for(int i=2; i*i <= n; i++) {
			if(n % i == 0) return false;
		}
		return true;
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
