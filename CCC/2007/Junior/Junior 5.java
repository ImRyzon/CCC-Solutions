import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		Integer loc[] = {0, 990, 1010, 1970, 2030, 2940, 3060, 3930, 4060, 4970, 5030, 5990, 6010, 7000};
		List<Integer> motel = new ArrayList(Arrays.asList(loc));
		int A = readInt(), B = readInt(), m = readInt();
		for(int i=1; i<=m; i++) motel.add(readInt());
		Collections.sort(motel);
		int n = motel.size();
		long dp[] = new long[n];  dp[0] = 1;
		for(int i=1; i<n; i++) {
			for(int j=i-1; j>=0; j--) {
				int dis = motel.get(i) - motel.get(j);
				if(dis >= A && dis <= B) dp[i] += dp[j];
			}
		}
		System.out.println(dp[n-1]);
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

	static char readCharacter() throws IOException {
		return next().charAt(0);
	}

	static String readLine() throws IOException {
		return br.readLine().trim();
	}
}
