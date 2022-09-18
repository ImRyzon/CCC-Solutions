import java.io.*;
import java.util.*;
public class Main {
    static FastIO r = new FastIO();
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String[] args) throws Exception {
        int n = r.readInt();
        for (int i = 0; i < n; i++) {
            String[] vowels = new String[4];
            for (int j = 0; j < 4; j++) {
                String[] line = r.readLine().split(" ");
                String vowelWord = line[line.length-1].replaceAll("[^AaEeIiOoUu]", "");
                if (vowelWord.length() == 0) vowels[j] = line[line.length-1];
                else {
                    char lastVowel = vowelWord.charAt(vowelWord.length()-1);
                    vowels[j] = line[line.length-1].substring(line[line.length-1].lastIndexOf(lastVowel));
                }
            }
            if (vowels[0].equalsIgnoreCase(vowels[1]) && vowels[1].equalsIgnoreCase(vowels[2]) && vowels[2].equalsIgnoreCase(vowels[3])) pr.println("perfect");
            else if (vowels[0].equalsIgnoreCase(vowels[1]) && vowels[2].equalsIgnoreCase(vowels[3])) pr.println("even");
            else if (vowels[0].equalsIgnoreCase(vowels[2]) && vowels[1].equalsIgnoreCase(vowels[3])) pr.println("cross");
            else if (vowels[0].equalsIgnoreCase(vowels[3]) && vowels[1].equalsIgnoreCase(vowels[2])) pr.println("shell");
            else pr.println("free");
            pr.flush();
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
