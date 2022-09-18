import java.io.*;
import java.util.*;
public class Main {
    static FastIO r = new FastIO();
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static List<Integer> adj[] = new ArrayList[10000];

    public static void main(String[] args) throws Exception {
        int n = r.readInt();
        for (int i = 1; i < 10000; i++) adj[i] = new ArrayList<>();
        for (int i = 0; i < n; i++) adj[r.readInt()].add(r.readInt());
        int x = r.readInt(), y = r.readInt();
        while (x != 0 && y != 0) {
            int ans = bfs(x, y);
            pr.println(ans == -1 ? "No" : "Yes " + ans);
            x = r.readInt(); y = r.readInt();
        }
        pr.close();
    }

    static int bfs(int st, int ed) {
        LinkedList<Integer> q = new LinkedList<>();
        int dis[] = new int[10000];
        boolean vis[] = new boolean[10000];
        vis[st] = true; q.add(st); dis[st] = 0;
        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : adj[u]) {
                if (!vis[v]) {
                    vis[v] = true;
                    q.add(v);
                    dis[v] = dis[u]+1;
                    if (v == ed) return dis[v]-1;
                }
            }
        }
        return -1;
    }

    static class FastIO extends PrintWriter {
        private InputStream stream;
        private byte[] buf = new byte[1 << 16];
        private int curChar, numChars;
        public FastIO() {this(System.in, System.out);}
        public FastIO(InputStream i, OutputStream o) {super(o);stream = i;}
        public FastIO(String i, String o) throws IOException {
            super(new FileWriter(o)); stream = new FileInputStream(i);
        }
        private int readByte() {
            if (numChars == -1) {throw new InputMismatchException();}
            if (curChar >= numChars) {
                curChar = 0;
                try {numChars = stream.read(buf);
                }catch(Exception e){throw new InputMismatchException();}
                if (numChars == -1) {return -1;}
            }
            return buf[curChar++];
        }
        public String next() {
            int c; do {c = readByte();} while (c <= ' ');
            StringBuilder res = new StringBuilder();
            do {res.appendCodePoint(c);c = readByte();} while (c > ' ');
            return res.toString();
        }
        public String readLine() {
            int c; do {c = readByte();} while (isEndLine(c));
            StringBuilder res = new StringBuilder();
            do {res.appendCodePoint(c);c = readByte();} while (c >= ' ');
            return res.toString();
        }
        public int readInt() {
            int c, sgn = 1, res = 0;
            do {c = readByte();} while (c <= ' ');
            if (c == '-') {sgn = -1;c = readByte();}
            do {
                if (c < '0' || c > '9') {throw new InputMismatchException();}
                res = 10 * res + c - '0';c = readByte();
            } while (c > ' ');
            return res * sgn;
        }
        public double readDouble() {return Double.parseDouble(next());}
        public long readLong() {return Long.parseLong(next());}
        boolean isEndLine(int c) {return c == '\n' || c == '\r' || c == -1;}
    }
}
