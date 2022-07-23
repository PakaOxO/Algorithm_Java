package level_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 중간 평균값 구하기
public class SWEA_1984 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCnt = Integer.parseInt(br.readLine());
		for (int i=0; i<testCnt; i++) {
			String[] input = br.readLine().split(" ");
			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			int sum = 0;
			for (int j=0; j<10; j++) {
				int num = Integer.parseInt(input[j]);
				if (num > max) max = num;
				if (num < min) min = num;
				sum += num;
			}
			
			System.out.printf("#%d %d\n", i + 1, Math.round((sum - max - min) / 8.0));
		}
		br.close();
	}

}
