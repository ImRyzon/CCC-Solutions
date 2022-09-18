import java.io.*;
import java.util.*;
public class Main {
    static FastIO r = new FastIO();
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String[] args) throws Exception {
        int curDay = r.readInt(), daysMonth = r.readInt(), counter = 1;
        pr.println("Sun Mon Tue Wed Thr Fri Sat");
        for (int i = 1; i <= curDay - 1; i++) {
            if (i == curDay-1) {pr.print("   "); break;}
            pr.print("    ");
        }
        if (curDay == 1) pr.print("  " + counter);
        else pr.print("   " + counter);
        counter++;
        if (curDay == 7) curDay = 1; else curDay++;
        for (int i = 2; i <= daysMonth; i++) {
            if (curDay == 1) {
                pr.println(); curDay++;
                if (counter >= 10) pr.print(" " + counter++);
                else pr.print("  " + counter++);
                continue;
            }
            if (counter >= 10) pr.print("  " + counter);
            else pr.print("   " + counter);
            if (curDay == 7) curDay = 1; else curDay++;
            counter++;
        }
        pr.println(); pr.close();
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
