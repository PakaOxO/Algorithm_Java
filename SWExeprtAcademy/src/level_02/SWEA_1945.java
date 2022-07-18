package level_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 간단한 소인수분해 
public class SWEA_1945 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCnt = Integer.parseInt(br.readLine());
		int[] divisor = { 2, 3, 5, 7, 11 };
		for (int i=0; i<testCnt; i++) {
			int N = Integer.parseInt(br.readLine());
			int[] cnt = new int[5];
			for (int j=divisor.length-1; j>=0; j--) {
				while (N % divisor[j] == 0) {
					cnt[j]++;
					N = N / divisor[j];
				}
			}
			System.out.printf("#%d %d %d %d %d %d\n", i + 1, cnt[0], cnt[1], cnt[2], cnt[3], cnt[4]);
		}
	}

}
