import java.io.*;
import java.util.*;
public class FastReader {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static Reader r = new Reader();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int array[] = new int[4];
        for (int i = 0; i < 4; i++) array[i] = r.readInt();
        if (array[0] == 8 || array[0] == 9) {
            if (array[3] == 8 || array[3] == 9) {
                if (array[1] == array[2]) {
                    System.out.println("ignore");
                } else {
                    System.out.println("answer");
                }
            } else {
                System.out.println("answer");
            }
        } else {
            System.out.println("answer");
        }
    }

    static class Reader {
        private int BUFFER_SIZE = 1 << 16, bufferPointer, bytesRead;
        private DataInputStream din;
        private byte[] buffer;
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
            boolean neg = (c == '-');
            if (neg) c = read();
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
            boolean neg = (c == '-');
            if (neg) c = read();
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
    static String next () throws IOException {
        while(st==null||!st.hasMoreTokens())st=new StringTokenizer(br.readLine().trim());return st.nextToken();
    }
    static long readLong () throws IOException {return Long.parseLong(next());}
    static int readInt () throws IOException {return Integer.parseInt(next());}
    static double readDouble () throws IOException {return Double.parseDouble(next());}
    static char readCharacter () throws IOException {return next().charAt(0);}
    static String readLine () throws IOException {return br.readLine().trim();}
}
