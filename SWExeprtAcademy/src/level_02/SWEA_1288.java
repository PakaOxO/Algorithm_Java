package level_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 새로운 불면증 치료법
public class SWEA_1288 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCnt = Integer.parseInt(br.readLine());
		for (int i=0; i<testCnt; i++) {
			int N = Integer.parseInt(br.readLine());
			int multiplier = 1;
			int[] numCnt = new int[10];
			while (true) {
				String[] kN = Integer.toString(N * multiplier).split("");
				for (String el:kN) {
					int num = Integer.parseInt(el);
					if (numCnt[num] == 0) numCnt[num]++;
				}
				
				boolean isFulled = true;
				for (int cnt:numCnt) {
					if (cnt == 0) {
						isFulled = false;
						break;
					}
				}
				if (isFulled) break;
				multiplier++;
			}
			System.out.printf("#%d %d\n", i + 1, N * multiplier);
		}
	}

}
