import java.io.*;
import java.util.*;
public class Main {
    static FastReader r = new FastReader();
    static BufferedWriter o = new BufferedWriter(new OutputStreamWriter(System.out));
    static PrintWriter pw;
    static boolean[][] grid = new boolean[250][250];

    static void solve() throws Exception {
        fillArray();
        int x = 12, y = 5, adjX = 12, adjY = 5;
        boolean doesWork = true;
        char dir = r.next().charAt(0);
        int vector = r.readInt();
        while (dir != 'q' && vector != 0) {
            if (dir == 'u') {
                adjY -= vector;
                for (int i = y-1; i >= adjY; i--) {
                    if (isValid(x, i)) grid[x][i] = true;
                    else {doesWork = false; break;}
                }
            } else if (dir == 'r') {
                adjX -= vector;
                for (int i = x-1; i >= adjX; i--) {
                    if (isValid(i, y)) grid[i][y] = true;
                    else {doesWork = false; break;}
                }
            } else if (dir == 'd') {
                adjY += vector;
                for (int i = y+1; i <= adjY; i++) {
                    if (isValid(x, i)) grid[x][i] = true;
                    else {doesWork = false; break;}
                }
            } else {
                adjX += vector;
                for (int i = x+1; i <= adjX; i++) {
                    if (isValid(i, y)) grid[i][y] = true;
                    else {doesWork = false; break;}
                }
            }
            o.write((11-adjX) + " " + -adjY + " ");
            grid[adjX][adjY] = true;
            if (doesWork) o.write("safe\n");
            else {o.write("DANGER\n"); break;}
            x = adjX; y = adjY;
            dir = r.next().charAt(0);
            vector = r.readInt();
        }
        o.flush();
    }

    static boolean isValid(int x, int y) {
        return !grid[x][y];
    }

    static void fillArray() {
        boolean temp[][] = {
            {false, false, false, false, false, false, false, false, false},
            {false, true, true, true, true, true, true, true, true},
            {false, true, true, true, true, true, true, true, true},
            {false, true, true, true, true, true, true, true, true},
            {false, true, true, false, false, false, false, false, true},
            {false, true, true, false, true, true, true, false, true},
            {false, true, true, false, false, false, true, false, true},
            {false,true, true, true, true, false, true, false, true},
            {false, true, true, false, false, false, true, false, true},
            {false, true, true, false, true, true, true, false, true},
            {false, true, true, false, true, true, true, false, true},
            {false, false, false, false, true, true, true, false, true},
            {false, true, true, true, true, false, false, false, true},
            {false, true, true, true, true, true, true, true, true},
            {false, true, true, true, true, true, true, true, true},
        };
        for (int i = 0; i <= 14; i++) {
            for (int j = 0; j <= 8; j++) {
                grid[i][j] = !temp[i][j];
            }
        }
    }

    public static void main(String[] args) throws Exception {
        int TEST_CASES = 1;
        while (TEST_CASES --> 0) solve();
    }

    static class FastReader extends PrintWriter {
        private final InputStream stream;
        private final byte[] buf = new byte[1 << 16];
        private int curChar, numChars;
        public FastReader() {this(System.in, System.out);}
        public FastReader(InputStream i, OutputStream o) {super(o);stream = i;}
        public FastReader(String i, String o) throws IOException {
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
