package level_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 아름이의 돌던지기
public class SWEA_1285 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCnt = Integer.parseInt(br.readLine());
		for (int i=0; i<testCnt; i++) {
			int N = Integer.parseInt(br.readLine());
			String[] input = br.readLine().split(" ");
			
			int min = Integer.MAX_VALUE;
			int cnt = 1;
			for (int j=0; j<N; j++) {
				int distance = Math.abs(Integer.parseInt(input[j]));
				if (distance <= min) {
					cnt = (distance < min) ? 1 : cnt + 1;
					min = distance;
				}
			}
			System.out.printf("#%d %d %d\n", i + 1, min, cnt);
		}
	}

}
