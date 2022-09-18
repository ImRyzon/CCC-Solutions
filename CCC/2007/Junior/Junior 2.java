import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = "";
        HashMap<String, String> dict = new HashMap <String, String>();
        dict.put("CU", "see you");
        dict.put(":-)", "I'm happy");
        dict.put(":-(", "I'm unhappy");
        dict.put(";-)", "wink");
        dict.put(":-P", "stick out my tongue");
        dict.put("(~.~)", "sleepy");
        dict.put("TA", "totally awesome");
        dict.put("CCC", "Canadian Computing Competition");
        dict.put("CUZ", "because");
        dict.put("TY", "thank-you");
        dict.put("YW", "you're welcome");
        dict.put("TTYL", "talk to you later");
        String get = "";
        do {
            line = sc.nextLine();
            get = dict.get(line);
            if (get == null) {
                System.out.println(line);
            } else {
                System.out.println(get);
                if (get.equalsIgnoreCase("talk to you later")) {
                    break;
                }
            }
        } while (!(line.equalsIgnoreCase("TTYL")));
    }
}
