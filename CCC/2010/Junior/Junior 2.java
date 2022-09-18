import java.io.*;
import java.util.*;
public class Main {
    static FastIO r = new FastIO();
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String[] args) throws Exception {
        Integer[] nikky = {r.readInt(), r.readInt()}, byron = {r.readInt(), r.readInt()};
        int total = r.readInt(), aSteps = 0, bSteps = 0, aCounter = 0, bCounter = 0;
        while (aSteps <= total) {
            if (aCounter + nikky[0] >= total) {aSteps += (total - aCounter); break;}
            aSteps += nikky[0]; aCounter += nikky[0];
            if (aCounter + nikky[1] >= total) {aSteps -= (total - aCounter); break;}
            aSteps -= nikky[1]; aCounter += nikky[1];
        }
        while (bSteps <= total) {
            if (bCounter + byron[0] >= total) {bSteps += (total - bCounter); break;}
            bSteps += byron[0]; bCounter += byron[0];
            if (bCounter + byron[1] >= total) {bSteps -= (total - bCounter); break;}
            bSteps -= byron[1]; bCounter += byron[1];
        }
        if (aSteps == bSteps) pr.println("Tied");
        else pr.println(aSteps > bSteps ? "Nikky" : "Byron");
        pr.close();
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
