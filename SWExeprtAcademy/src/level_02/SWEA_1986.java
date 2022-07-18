package level_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 지그재그 숫자
public class SWEA_1986 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCnt = Integer.parseInt(br.readLine());
		for (int i=0; i<testCnt; i++) {
			int N = Integer.parseInt(br.readLine());
			int result = N % 2 == 0 ? -(N / 2) : N - ((N - 1) / 2);
			System.out.printf("#%d %d\n", i + 1, result);
		}
	}

}
