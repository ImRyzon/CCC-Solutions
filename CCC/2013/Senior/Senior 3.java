import java.io.*;
import java.util.*;
public class Main {
    static FastIO r = new FastIO();
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static List<Integer> adj[];
    static int game, team, ways=0, remain[][], pts[];

    public static void main(String[] args) throws Exception {
        team = r.readInt(); game = r.readInt(); pts = new int[5];
        boolean vis[][] = new boolean [5][5];
        for(int i=1; i<=game; i++) {
            int a = r.readInt(), b = r.readInt(), sa = r.readInt(), sb = r.readInt();
            vis[a][b] = true;
            if(sa > sb) pts[a]+=3;
            else if(sa < sb) pts[b]+=3;
            else { pts[a]++;  pts[b]++;}
        }
        int rest = 6 - game, cnt = 0;  remain = new int[rest][2];
        for(int i=1; i<=4; i++)
            for(int j=i+1; j<=4; j++)
                if(!vis[i][j]) { remain[cnt][0]=i; remain[cnt][1]=j; cnt++;}
        fun(cnt-1);
        System.out.println(ways);
    }
    static void fun(int idx) {
        if(idx < 0) { //base case
            for(int i=1; i<=4; i++)
                if(i != team && pts[i] >= pts[team]) return;
            ways++;  return;
        }
        int x = remain[idx][0],  y = remain[idx][1];
        pts[x] += 3;   //assume x win
        fun(idx-1);
        pts[x] -= 3;  pts[y]+=3 ;  //assume y win
        fun(idx-1);
        pts[y]-= 3;   pts[x]++;  pts[y]++;  //assume tie;
        fun(idx-1);
        pts[x]--; pts[y]--;
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
