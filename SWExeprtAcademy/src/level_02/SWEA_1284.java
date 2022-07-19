package level_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 수도 요금 경쟁
public class SWEA_1284 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCnt = Integer.parseInt(br.readLine());
		
		for (int i=0; i<testCnt; i++) {
			String[] input = br.readLine().split(" ");
			int P = Integer.parseInt(input[0]);
			int Q = Integer.parseInt(input[1]);
			int R = Integer.parseInt(input[2]);
			int S = Integer.parseInt(input[3]);
			int W = Integer.parseInt(input[4]);
			
			int priceA = P * W;
			int priceB = (W > R) ? Q + (W - R) * S : Q;
			
			System.out.printf("#%d %d\n", i + 1, priceA > priceB ? priceB : priceA);
		}
		
	}

}
