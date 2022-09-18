import java.io.*;
import java.util.*;
public class Main {
    static FastIO r = new FastIO();
    static BufferedWriter o = new BufferedWriter(new OutputStreamWriter(System.out));
    static int dis[][], h, w;
    static char grid[][];
    static int vectorAll[][] = {{-1, 0, 1, 0}, {0, 1, 0, -1}};
    static int vectorEW[][] = {{0, 0}, {-1, 1}};
    static int vectorNS[][] = {{1, -1}, {0, 0}};

    public static void main(String[] args) throws Exception {
        int t = r.readInt();
        for (int x = 0; x < t; x++) {
            h = r.readInt(); w = r.readInt();
            dis = new int[h+1][w+1]; grid = new char[h+1][w+1];
            for (int i = 1; i <= h; i++) {
                System.arraycopy(r.readLine().toCharArray(), 0, grid[i], 1, w);
            }
            if (grid[1][1] == '*') {System.out.println(-1); continue;}
            bfs(1, 1);
            System.out.println(dis[h][w] == 0 ? -1 : dis[h][w]);
        }
    }

    static void bfs (int x, int y) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(x, y));
        dis[x][y] = 1;
        while (!q.isEmpty()) {
            Pair cell = q.peek();
            int a = cell.first, b = cell.second;
            if (a == h && b == w) return;
            q.remove();
            if (grid[a][b] == '+') {
                for (int i = 0; i < 4; i++) {
                    int adjA = a + vectorAll[0][i], adjB = b + vectorAll[1][i];
                    if (isValid(adjA, adjB)) {
                        q.add(new Pair(adjA, adjB));
                        dis[adjA][adjB] = dis[a][b] + 1;
                    }
                }
            } else if (grid[a][b] == '-') {
                for (int i = 0; i < 2; i++) {
                    int adjA = a + vectorEW[0][i], adjB = b + vectorEW[1][i];
                    if (isValid(adjA, adjB)) {
                        q.add(new Pair(adjA, adjB));
                        dis[adjA][adjB] = dis[a][b] + 1;
                    }
                }
            } else {
                for (int i = 0; i < 2; i++) {
                    int adjA = a + vectorNS[0][i], adjB = b + vectorNS[1][i];
                    if (isValid(adjA, adjB)) {
                        q.add(new Pair(adjA, adjB));
                        dis[adjA][adjB] = dis[a][b] + 1;
                    }
                }
            }
        }
    }

    static class Pair {
        int first, second;
        public Pair(int first, int second) {this.first = first; this.second = second;}
    }

    static boolean isValid(int row, int col) {
        if (row < 1 || col < 1 || row > h || col > w) return false;
        if (grid[row][col] == '*') return false;
        return dis[row][col] == 0;
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
