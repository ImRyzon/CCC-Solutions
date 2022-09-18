import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int X = readInt(); 
		String []x1 = new String[X], x2 = new String[X];
		for(int i=0; i<X; i++) {
			x1[i] = next(); x2[i] = next();
		}
		int Y = readInt();
		String [] y1 = new String[Y], y2 = new String[Y];
		for(int i=0; i<Y; i++) {
			y1[i] = next(); y2[i] = next();
		}
		int G = readInt(); Map<String, Integer> map = new HashMap();
		for(int i=1; i<=G; i++) {
			map.put(next(), i);
			map.put(next(), i);
			map.put(next(), i);
		}
		int ans = 0;
		for(int i=0; i<X; i++) {
			int ga = map.get(x1[i]), gb = map.get(x2[i]);
			if(ga != gb) ans++;
		}
		for(int i=0; i<Y; i++) {
			int ga = map.getOrDefault(y1[i], 0), gb = map.getOrDefault(y2[i], 0);
			if(ga == gb && ga >= 1 && ga <= G) ans++;
		}
		System.out.println(ans);
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
