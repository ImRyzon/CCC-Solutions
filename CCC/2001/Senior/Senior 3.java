import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	static boolean [][] adj = new boolean[26][26]; static int cnt;
	public static void main(String[] args) throws IOException{
		List<String> lst = new ArrayList<>();
		while(true) {
			String t = next(); 
			char [] s = t.toCharArray();
			if(s[0] == '*') break;
			lst.add(t);
			int u = s[0] - 'A', v = s[1] - 'A';
			adj[u][v] = adj[v][u] = true;
		}
		for(String s : lst) {
			int u = s.charAt(0) - 'A', v = s.charAt(1) - 'A';
			adj[u][v] = adj[v][u] = false;
			if(!bfs(0, 1)) {
				System.out.println(s); cnt++;
			}
			adj[u][v] = adj[v][u] = true;
		}
		System.out.println("There are "+cnt+" disconnecting roads.");
	}
	static boolean bfs(int src, int dst) {
		Queue<Integer> q= new LinkedList<>(); 
		boolean [] vis = new boolean[26];
		q.add(src); vis[src] = true;
		while(!q.isEmpty()) {
			int cur = q.poll();
			for(int nxt=0; nxt<26; nxt++) {
				if(adj[cur][nxt] && !vis[nxt]) {
					q.add(nxt); vis[nxt]=true;
				}
			}
			if(vis[dst]) return true;
		}
		return false;
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
