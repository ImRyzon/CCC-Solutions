import java.io.*;
import java.util.*;
public class Main {
    static FastIO r = new FastIO();
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static List<Integer> adj[];

    public static void main(String[] args) throws Exception {
        char c = r.next().charAt(0);
        adj = new ArrayList[50];
        for (int i = 1; i < 50; i++) adj[i] = new ArrayList<>();
        initial();
        while (c != 'q') {
            if (c == 'i') {
                int u = r.readInt(), v = r.readInt();
                if (adj[u].contains(v)) continue;
                adj[u].add(v); adj[v].add(u);
            } else if (c == 'd') {
                int u = r.readInt(), v = r.readInt();
                adj[u].remove(adj[u].indexOf(v));
                adj[v].remove(adj[v].indexOf(u));
            } else if (c == 'n') {
                pr.println(adj[r.readInt()].size());
            } else if (c == 'f') {
                int sum = 0, friend = r.readInt();
                List<Integer> alreadyCounted = new ArrayList<>();
                for (int u : adj[friend]) {
                    for (int i = 0; i < adj[u].size(); i++) {
                        if (adj[friend].contains(adj[u].get(i)) || adj[u].get(i) == friend || alreadyCounted.contains(adj[u].get(i))) continue;
                        sum++; alreadyCounted.add(adj[u].get(i));
                    }
                }
                pr.println(sum);
            } else if (c == 's') {
                int degree = bfs(r.readInt(), r.readInt());
                pr.println(degree == -1 ? "Not connected" : degree);
            }
            c = r.next().charAt(0);
        }
        pr.close();
    }

    static int bfs (int st, int ed) {
        LinkedList<Integer> q = new LinkedList<>();
        int dis[] = new int[50];
        boolean vis[] = new boolean[50];
        q.add(st); vis[st] = true; dis[st] = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int nxt : adj[cur]) {
                if (!vis[nxt]) {
                    q.add(nxt);
                    vis[nxt] = true;
                    dis[nxt] = dis[cur] + 1;
                    if (nxt == ed) return dis[ed];
                }
            }
        }
        return -1;
    }

    static void initial () {
        adj[1].add(6);adj[2].add(6);adj[3].add(4);adj[3].add(5);adj[3].add(6);
        adj[3].add(15);adj[4].add(3);adj[4].add(5);adj[4].add(6);adj[5].add(3);
        adj[5].add(3);adj[5].add(4);adj[5].add(6);adj[6].add(1);adj[6].add(2);
        adj[6].add(3);adj[6].add(4);adj[6].add(5);adj[6].add(7);adj[7].add(6);
        adj[7].add(8);adj[8].add(7);adj[8].add(9);adj[9].add(8);adj[9].add(10);
        adj[9].add(12);adj[10].add(9);adj[10].add(11);adj[11].add(10);
        adj[11].add(12);adj[12].add(9);adj[12].add(11);adj[12].add(13);
        adj[13].add(12);adj[13].add(14);adj[13].add(15);adj[14].add(13);
        adj[15].add(3);adj[15].add(13);adj[16].add(17);adj[16].add(18);
        adj[17].add(16);adj[17].add(18);adj[18].add(16);adj[18].add(17);
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
