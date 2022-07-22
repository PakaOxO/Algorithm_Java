package level_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 시각 덧셈
public class SWEA_1976 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCnt = Integer.parseInt(br.readLine());
		for (int i=0; i<testCnt; i++) {
			String[] input = br.readLine().split(" ");
			int h1 = Integer.parseInt(input[0]);
			int m1 = Integer.parseInt(input[1]);
			
			int h2 = Integer.parseInt(input[2]);
			int m2 = Integer.parseInt(input[3]);
			
			int m = (m1 + m2) % 60;
			int h = (h1 + h2 + ((m1 + m2) / 60)) % 12;
			if (h == 0) h = 12;
			System.out.printf("#%d %d %d\n", i + 1, h, m);
		}
		br.close();
	}

}
