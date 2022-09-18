import java.io.*;
import java.util.*;
public class LunchConcert {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static Reader r = new Reader();
    static StringTokenizer st;
    static int n, p[], w[], d[];

    public static void main(String[] args) throws IOException {
        n = r.readInt(); p = new int[n]; w = new int[n]; d = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = r.readInt(); w[i] = r.readInt(); d[i] = r.readInt();
        }
        int lft = 0, rit = (int)1e9+1;
        while (lft < rit) {
            int mid = (lft + rit)/2;
            if (f(mid) < f(mid + 1)) {
                rit = mid;
            } else {
                lft = mid+1;
            }
        }
        pr.println(f(lft)); pr.flush();
    }

    static long f(int x) {
        long cost = 0;
        for (int i = 0; i < n; i++) {
            if (x < p[i] - d[i]) {
                cost += (long) (p[i]-d[i]-x) * w[i];
            }
            if (x > p[i] + d[i]) {
                cost += (long) (x - p[i] - d[i]) * w[i];
            }
        }
        return cost;
    }

    static class Reader {
        private int BUFFER_SIZE = 1 << 16, bufferPointer, bytesRead;
        private DataInputStream din; private byte[] buffer;
        public Reader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE]; bufferPointer = bytesRead = 0;
        }
        public Reader(String file_name) throws IOException {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE]; bufferPointer = bytesRead = 0;
        }
        public String readLine() throws IOException {
            byte[] buf = new byte[64]; int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n') {if (cnt != 0) break; else continue;}
                buf[cnt++] = (byte)c;
            }
            return new String(buf, 0, cnt);
        }
        public int readInt() throws IOException {
            int ret = 0; byte c = read();
            while (c <= ' ') c = read();
            boolean neg = (c == '-'); if (neg) c = read();
            do {ret = ret * 10 + c - '0';} while ((c = read()) >= '0' && c <= '9');
            if (neg) return -ret; return ret;
        }
        public long readLong() throws IOException {
            long ret = 0; byte c = read();
            while (c <= ' ') c = read();
            boolean neg = (c == '-');
            if (neg) c = read();
            do {ret = ret * 10 + c - '0';} while ((c = read()) >= '0' && c <= '9');
            if (neg) return -ret; return ret;
        }
        public double readDouble() throws IOException {
            double ret = 0, div = 1; byte c = read();
            while (c <= ' ') c = read();
            boolean neg = (c == '-');if (neg) c = read();
            do {ret = ret * 10 + c - '0';} while ((c = read()) >= '0' && c <= '9');
            if (c == '.') {while ((c = read()) >= '0' && c <= '9') ret += (c - '0') / (div *= 10);}
            if (neg) return -ret; return ret;
        }
        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1) buffer[0] = -1;
        }
        private byte read() throws IOException {
            if (bufferPointer == bytesRead) fillBuffer(); return buffer[bufferPointer++];
        }
        public void close() throws IOException {if (din == null) return;din.close();}
    }
    static long readLong () throws IOException {return Long.parseLong(next());}
    static int readInt () throws IOException {return Integer.parseInt(next());}
    static double readDouble () throws IOException {return Double.parseDouble(next());}
    static char readCharacter () throws IOException {return next().charAt(0);}
    static String readLine () throws IOException {return br.readLine().trim();}
    static String next () throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }
}
