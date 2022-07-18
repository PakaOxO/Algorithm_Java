package level_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 몫과 나머지 출력하기
public class SWEA_2029 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCnt = Integer.parseInt(br.readLine());
		for (int i=0; i<testCnt; i++) {
			String[] input = br.readLine().split(" ");
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);
			
			System.out.printf("#%d %d %d\n", i + 1, a / b, a % b);
		}
	}
}
