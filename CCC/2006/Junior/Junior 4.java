import java.util.*;
import java.io.*;
public class ItsToughBeingATeen {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int[][] adj = new int[10][10];
        int [] cnt = new int[10];
        adj[1][7] = 1;
        adj[1][4] = 1;
        adj[2][1] = 1;
        adj[3][4] = 1;
        adj[3][5] = 1;
        cnt[7] = 1;
        cnt[4] = 2;
        cnt[1] = 1;
        cnt[5] = 1;
        while(true) {
            int a = readInt();
            int b = readInt();
            adj[a][b] = 1;
            cnt[b]++;
            if(a==0||b==0)
                break;
        }
        int index =0;
        int [] order = new int[10];
        for(int i=1;i<=7;i++){
            for(int j=1;j<=7;j++){
                if(cnt[j]==0){
                    order[++index] = j;
                    cnt[j]= -1;
                    for(int k=1;k<=7;k++){
                        if(adj[j][k]==1){
                            adj[j][k] =0;
                            cnt[k]--;
                        }
                    }
                    break;
                }
            }
        }
        if(index<7)
            System.out.println("Cannot complete these tasks. Going to bed.");
        else{
            for(int i =1;i<=7;i++){
                System.out.print(order[i]+" ");
            }
        }
    }

    static String next () throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }
    static long readLong () throws IOException {
        return Long.parseLong(next());
    }
    static int readInt () throws IOException {
        return Integer.parseInt(next());
    }
    static double readDouble () throws IOException {
        return Double.parseDouble(next());
    }
    static char readCharacter () throws IOException {
        return next().charAt(0);
    }
    static String readLine () throws IOException {
        return br.readLine().trim();
    }
}
