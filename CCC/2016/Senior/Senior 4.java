import java.io.*;
import java.util.*;
public class Main {
    static FastIO r = new FastIO();
    static PrintWriter p = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static BufferedWriter b = new BufferedWriter(new OutputStreamWriter(System.out));
    static OutputStream o = new BufferedOutputStream(System.out);

    public static void main(String[] args) throws Exception {
        int n = r.readInt(), psa[] = new int[n+1], ans = 0; boolean dp[][] = new boolean[n+1][n+1];
        for(int i=1; i<=n; i++) {
            psa[i] = r.readInt(); ans = Math.max(ans, psa[i]);
            psa[i] += psa[i-1]; dp[i][i] = true;
        }
        for(int len=1; len<n; len++) {
            for(int L=1; L+len<=n; L++) {
                int R = L + len;
                for(int p=L, q=R; p<q; ) {
                    int sumL = psa[p] - psa[L-1], sumR = psa[R] - psa[q-1];
                    if(dp[L][p] && dp[q][R] && p+1 == q && sumL == sumR) {
                        dp[L][R] = true;
                    }else if(dp[L][p] && dp[q][R] && dp[p+1][q-1] && sumL == sumR) {
                        dp[L][R] = true;
                    }
                    if(dp[L][R]) ans = Math.max(ans, psa[R] - psa[L-1]);
                    if(sumL < sumR) p++;
                    else q--;
                }
            }
        }
        b.write(ans + "\n"); b.close();
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
