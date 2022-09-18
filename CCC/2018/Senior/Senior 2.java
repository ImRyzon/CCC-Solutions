import java.io.*;
import java.util.*;
public class Main {
    static FastIO r = new FastIO();
    static BufferedWriter o = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        int n = r.readInt(), arr[][] = new int[n][n];
        boolean doesWork = true;
        for (int i = 0; i < n; i++) {for (int j = 0; j < n; j++) {arr[i][j] = r.readInt();}}
        for (int i = 0; i < 4; i++) {
            rotate(arr);
            for (int j = 1; j < n; j++) {if ((arr[0][j] < arr[0][j-1]) || (arr[j][0] < arr[j-1][0])) {doesWork = false; break;}}
            if (doesWork) break;
            doesWork = true;
        }
        for (int i = 0; i < n; i++) {for (int j = 0; j < n-1; j++) {System.out.print(arr[i][j] + " ");}System.out.println(arr[i][n-1]);}
    }

    static void rotate(int arr[][]) {
        int n = arr.length, a, b, c , d;
        for (int i = 0; i <= n / 2 - 1; i++) {
            for (int j = 0; j <= n - 2 * i - 2; j++) {
                a = arr[i + j][i];
                b = arr[n - 1 - i][i + j];
                c = arr[n - 1 - i - j][n - 1 - i];
                d = arr[i][n - 1 - i - j];
                arr[i + j][i] = d;
                arr[n - 1 - i][i + j] = a;
                arr[n - 1 - i - j][n - 1 - i] = b;
                arr[i][n - 1 - i - j] = c;
            }
        }
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
