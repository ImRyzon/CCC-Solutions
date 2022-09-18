import java.io.*;
import java.util.*;
public class EscapeRoom {
    static FastIO r = new FastIO();
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String[] args) throws IOException{
        int R = r.readInt(), C = r.readInt(), maxV = (int)1e6;
        List<Integer> adj[] = new ArrayList[maxV+1];
        for(int i=1; i<=maxV; i++) adj[i] = new ArrayList();
        for(int i=1; i<=R; i++) {
            for(int j=1; j<=C; j++) {
                adj[i*j].add(r.readInt());
            }
        }
        Queue<Integer> q = new LinkedList<>();
        boolean vis[] = new boolean[maxV+1];
        q.add(1); vis[1]=true;
        while(!q.isEmpty()) {
            int cur = q.poll();
            for(int nxt : adj[cur]) {
                if(!vis[nxt]) { q.add(nxt); vis[nxt]=true; }
            }
        }
        pr.println(vis[R*C]? "yes" : "no"); pr.flush();
    }
    static long gcd(long x, long y) {
        return y==0? x : gcd(y, x%y);
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
