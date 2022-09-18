import java.io.*;
import java.util.*;
public class Main {
    static FastIO r = new FastIO();
    static BufferedWriter o = new BufferedWriter(new OutputStreamWriter(System.out));
    static boolean[][] vis = new boolean[9][9];
    static int dis[][] = new int[9][9], endX, endY, ROW = 8, COL = 8;
    static Integer vectorX[] = {-1, -2, -2, -1, 1, 2, 1, 2};
    static Integer vectorY[] = {-2, -1, 1, 2, -2, -1, 2, 1};

    public static void main(String[] args) throws Exception {
        int startX = r.readInt(), startY = r.readInt(); endX = r.readInt(); endY = r.readInt();
        bfs(startX, startY);
        System.out.println(dis[endX][endY]);
    }

    static void bfs (int x, int y) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(x, y));
        vis[x][y] = true;
        while (!q.isEmpty()) {
            Pair cell = q.peek();
            int a = cell.first, b = cell.second;
            if (a == endX && b == endY) return;
            q.remove();
            for (int i = 0; i < 8; i++) {
                int adjA = a + vectorX[i], adjB = b + vectorY[i];
                if (isValid(adjA, adjB)) {
                    q.add(new Pair(adjA, adjB));
                    vis[adjA][adjB] = true;
                    dis[adjA][adjB] = (dis[a][b] + 1);
                }
            }
        }
    }

    static class Pair {
        int first, second;
        public Pair(int first, int second) {this.first = first; this.second = second;}
    }

    static boolean isValid(int row, int col) {
        if (row < 1 || col < 1 || row > ROW || col > COL) return false;
        return !vis[row][col];
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
