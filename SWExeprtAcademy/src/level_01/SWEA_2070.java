package level_01;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//큰 놈, 작은 놈, 같은 놈 
public class SWEA_2070 {
 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCnt = Integer.parseInt(br.readLine());
		
		for (int i=0; i<testCnt; i++) {
			String[] input = br.readLine().split(" ");
			int a, b;
			String result;
			a = Integer.parseInt(input[0]);
			b = Integer.parseInt(input[1]);
			
			if (a > b) result = ">";
			else if (a < b) result = "<";
			else result = "=";
			
			System.out.printf("#%d %s\n", i + 1, result);
		}
	}

}
