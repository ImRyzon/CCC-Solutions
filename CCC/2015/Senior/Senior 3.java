import java.util.*;
import java.io.*;
public class ccc15s3 {
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int G = Integer.parseInt(br.readLine()), P = Integer.parseInt(br.readLine());
		int cnt=0;
		TreeSet<Integer> tree = new TreeSet<Integer>();
		for(int i=1; i<=G; i++)
			tree.add(i);
		for(int i=0; i<P; i++){
			int g = Integer.parseInt(br.readLine()); 
			Integer a = tree.floor(g);
			if(a==null){
				System.out.println(cnt);
				return;
			}else{
				tree.remove(a); cnt++;
			}
		}
		System.out.println(cnt);
	}
}
