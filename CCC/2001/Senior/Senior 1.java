import java.io.*;
import java.util.*;
public class Main {
    static FastIO r = new FastIO();
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String[] args) throws Exception {

        String s = r.readLine();
        int i = 0;
        char cur = 'C';

        String clubs = "", diamonds = "", hearts = "", spades = "";
        int clubsPoint = 0, diamondPoint = 0, heartsPoint = 0, spadesPoint = 0;

        Map<Character, Integer> translate = new HashMap<>();
        translate.put('A', 4);
        translate.put('K', 3);
        translate.put('Q', 2);
        translate.put('J', 1);

        for (i = 1; i < s.length(); i++) {
            if (s.charAt(i) == 'D' || s.charAt(i) == 'H' || s.charAt(i) == 'S') {
                cur = s.charAt(i);
                continue;
            }
            if (cur == 'C')  {
                clubs += (s.charAt(i) + " ");
                if (s.charAt(i) == 'A' || s.charAt(i) == 'K' || s.charAt(i) == 'Q' || s.charAt(i) == 'J') {
                    clubsPoint += translate.get(s.charAt(i));
                }
            }
            if (cur == 'D') {
                diamonds += (s.charAt(i) + " ");
                if (s.charAt(i) == 'A' || s.charAt(i) == 'K' || s.charAt(i) == 'Q' || s.charAt(i) == 'J') {
                    diamondPoint += translate.get(s.charAt(i));
                }
            }
            if (cur == 'H') {
                hearts += (s.charAt(i) + " ");
                if (s.charAt(i) == 'A' || s.charAt(i) == 'K' || s.charAt(i) == 'Q' || s.charAt(i) == 'J') {
                    heartsPoint += translate.get(s.charAt(i));
                }
            }
            if (cur == 'S') {
                spades += (s.charAt(i) + " ");
                if (s.charAt(i) == 'A' || s.charAt(i) == 'K' || s.charAt(i) == 'Q' || s.charAt(i) == 'J') {
                    spadesPoint += translate.get(s.charAt(i));
                }
            }
        }

        if (clubs.replaceAll(" ", "").length() < 3) {
            clubsPoint += (3 - clubs.replaceAll(" ", "").length());
        }
        if (diamonds.replaceAll(" ", "").length() < 3) {
            diamondPoint += (3 - diamonds.replaceAll(" ", "").length());
        }
        if (hearts.replaceAll(" ", "").length() < 3) {
            heartsPoint += (3 - hearts.replaceAll(" ", "").length());
        }
        if (spades.replaceAll(" ", "").length() < 3) {
            spadesPoint += (3 - spades.replaceAll(" ", "").length());
        }

        pr.println("Cards Dealt              Points");
        pr.println("Clubs " + clubs + "     " + clubsPoint);
        pr.println("Diamonds " + diamonds + "     " + diamondPoint);
        pr.println("Hearts " + hearts + "     " + heartsPoint);
        pr.println("Spades " + spades + "     " + spadesPoint);
        pr.println("                       Total " + (clubsPoint+diamondPoint+heartsPoint+spadesPoint));
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
