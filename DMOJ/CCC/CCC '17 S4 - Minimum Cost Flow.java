import java.util.*;

import java.io.*;
import java.math.BigInteger;
public class Main {
	static BufferedReader br; static FileWriter fw; static PrintWriter pw; static StringTokenizer st;
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
	static short readShort () throws IOException {
		return Short.parseShort(next());
	}
	static double readDouble () throws IOException {
		return Double.parseDouble(next());
	}
	static char readChar () throws IOException {
		return next().charAt(0);
	}
	static String readLine () throws IOException {
		return br.readLine().trim();
	}
	static void print(String s) {
		pw.print(s); pw.flush();
	}
	static void println() {
		pw.println(); pw.flush();
	}
	static void println(String s) {
		pw.println(s); pw.flush();
	}
	static void println(int s) {
		pw.println(s); pw.flush();
	}
	static void println(long s) {
		pw.println(s); pw.flush();
	}
	static void init(int n) {
		adj = new ArrayList[n];
		for(int i = 0; i < n; i++) {
			adj[i] = new ArrayList();
		}
	}
	static class DisjointSet{
		//Integer implementation of disjoint set
    	int[] rank; int[] parent; int[] size; boolean[] cycle;
    	int n;
    	public DisjointSet(int size) {
    		rank = new int[size];
    		parent = new int[size];
    		this.size = new int[size];
    		cycle = new boolean[size];
    		n = size;
    		makeSet();
    	}
    	public void makeSet() {
    		for(int i = 0; i < n; i++) {
    			parent[i] = i; size[i] = 1;
    		}
    	}
    	public int find(int x) {
    		if(parent[x] == x) {
    			return x;
    		}
    		int result = find(parent[x]);
    		parent[x] = result;
    		return result;
    	}
    	public void union(int x, int y) {
    		int xRoot = find(x); int yRoot = find(y);
    		if(xRoot==yRoot) {
    			cycle[xRoot] = true;
    			return;
    		}
    		if(rank[xRoot]<rank[yRoot]) {
    			parent[xRoot] = yRoot;
    			size[yRoot]+=size[xRoot];
    		}
    		else if(rank[xRoot]>rank[yRoot]) {
    			parent[yRoot] = xRoot;
    			size[xRoot]+=size[yRoot];
    		}
    		else {
    			parent[yRoot] = xRoot;
    			size[xRoot]+=size[yRoot];
    			rank[xRoot] = rank[xRoot]+1;
    		}
    	}
    	public int getSize(int a) {
    		return size[find(a)];
    	}
    	public boolean sameSet(int x, int y) {
    		return find(x) == find(y);
    	}
    	public boolean hasCycle(int a) {
    		return cycle[find(a)];
    	}
    }
	public static void main(String[] args) throws IOException{
		if(dmoj) {
			br = new BufferedReader(new InputStreamReader(System.in));
			pw = new PrintWriter(System.out);
		}
		else {
			//Configure output here
			br = new BufferedReader(new FileReader("input.txt"));
			fw = new FileWriter("output.txt");
			pw = new PrintWriter(fw);
		}
		if(doCases) {
			int t = readInt();
			for(int i = 0; i < t; i++) {
				solve();
			}
		}
		else solve();
		pw.close();
    }
	//------------------------------------------------------------
	static class Edge implements Comparable<Edge>{
		boolean isOld; int u; int v; int w;
		public Edge(int a, int b, int c, boolean d) {
			u = a; v = b; w = c; isOld = d;
		}
		public int compareTo(Edge e) {
	       	if(w == e.w && isOld != e.isOld) {
	       		if(isOld) return -1;
	       		return 1;
	       	}
	       	return Integer.compare(w, e.w);
	    }
		
	}
	static boolean doCases = false; static boolean dmoj = true;
	static List<Integer> adj[];
	static void solve() throws IOException {
		int n = readInt(); int m = readInt(); int d = readInt();
		DisjointSet ds = new DisjointSet(n+1); Edge[] edges = new Edge[m];
		for(int i = 0; i < m; i++) {
			int a = readInt(); int b = readInt(); int w = readInt();
			if(i < n-1) {
				edges[i] = new Edge(a, b, w, true);
			}
			else edges[i] = new Edge(a, b, w, false);
		}
		Arrays.sort(edges); int newPipe = 0; Edge worst = new Edge(0, 0, 0, false);
		for(int i = 0; i < m; i++) {
			Edge e = edges[i];
			if(ds.sameSet(e.u, e.v)) {
				continue;
			}
			if(!e.isOld) {
				newPipe++;
			}
			worst = e;
			ds.union(e.u,  e.v);
		}
		if(!worst.isOld) {
			DisjointSet ds2 = new DisjointSet(n+1); 
			for(int i = 0; i < m; i++) {
				if(!ds2.sameSet(edges[i].u, edges[i].v)) {
					if(edges[i].w < worst.w || (edges[i].w==worst.w && edges[i].isOld)) {
						ds2.union(edges[i].u, edges[i].v);
					}else if(edges[i].w <= d && edges[i].isOld) {
						newPipe--; break;
					}
				}
			}
		}
		System.out.println(newPipe);
		
		
		
	}
	
}
