import java.io.*;
import java.util.*;
public class ShopAndShip {
    static FastIO r = new FastIO();
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String[] args) throws Exception {
        int n = r.readInt(), m = r.readInt(), adj[][] = new int[n+1][n+1];
        for (int i = 1; i <= m; i++) {
            int u = r.readInt(), v = r.readInt(), w = r.readInt();
            adj[u][v] = adj[v][u] = w;
        }
        int k = r.readInt(), city[] = new int[k], price[] = new int[k];
        for (int i = 0; i < k; i++) {
            city[i] = r.readInt(); price[i] = r.readInt();
        }
        int dest = r.readInt(), dis[] = new int[n+1];
        boolean vis[] = new boolean[n+1];
        Arrays.fill(dis, Integer.MAX_VALUE); dis[dest] = 0;
        for (int r = 1; r <= n; r++) {
            int u = -1, min = Integer.MAX_VALUE;
            for (int i = 1; i <= n; i++) {
                if (!vis[i] && dis[i] < min) {min = dis[i]; u = i;}
            }
            if (u == -1) break;
            vis[u] = true;
            for (int v = 1; v <= n; v++) {
                if (adj[u][v] > 0 && dis[v] > dis[u] + adj[u][v])
                    dis[v] = dis[u] + adj[u][v];
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < k; i++) ans = Math.min(ans, dis[city[i]] + price[i]);
        pr.println(ans); pr.flush();
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
