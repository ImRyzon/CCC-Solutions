import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n, m, start, node=0, far, len; static List<Integer> adj[]; static boolean pho[];
	public static void main(String[] args) throws IOException{
		n = readInt(); m = readInt(); adj = new ArrayList[n]; pho = new boolean[n];
		for(int i=0; i<n; i++) adj[i] = new ArrayList();
		for(int i=1; i<=m; i++) {
			start = readInt(); pho[start] = true;
		}
		for(int i=1; i<n; i++) {
			int u = readInt(), v = readInt();
			adj[u].add(v); adj[v].add(u);
		}
		dfs(start, -1);
		len = 0; dfs2(start, -1, 0);
		len = 0; dfs2(far, -1, 0);
		System.out.println(2*(node-1) - len);
	}
	static void dfs(int u, int pre) {
		for(int v: adj[u]) {
			if(v != pre) {
				dfs(v, u);
				if(pho[v]) pho[u] = true;
			}
		}
		if(pho[u]) node++;
	}
	static void dfs2(int u, int pre, int dis) {
		if(dis > len) { len = dis; far = u; }
		for(int v: adj[u]) {
			if(v != pre && pho[v]) dfs2(v, u, dis+1);
		}
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
