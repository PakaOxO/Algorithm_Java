package level_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 최대수 구하기
public class SWEA_2068 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCnt = Integer.parseInt(br.readLine());
		for (int i=0; i<testCnt; i++) {
			String[] input = br.readLine().split(" ");
			int max = Integer.MIN_VALUE;
			for (String el:input) {
				int num = Integer.parseInt(el);
				max = Math.max(max, num);
			}
			System.out.printf("#%d %d\n", i + 1, max);
		}
	}

}
