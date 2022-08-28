package logic;

import java.io.*;

// 돌 게임 3
public class BaekJoon_9657 {
	static boolean[] shouldSKWin = new boolean[1001];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		shouldSKWin[1] = true;
		shouldSKWin[3] = true;
		shouldSKWin[4] = true;
		if (N <= 4) {
			if (shouldSKWin[N]) System.out.println("SK");
			else System.out.println("CY");
		} else {
			for (int i=5; i<=N; i++) {
				if (!shouldSKWin[i - 1]) {
					shouldSKWin[i] = true;
					continue;
				}
				if (!shouldSKWin[i - 3]) {
					shouldSKWin[i] = true;
					continue;
				}
				if (!shouldSKWin[i - 4]) {
					shouldSKWin[i] = true;
					continue;
				}
			}
			if (shouldSKWin[N]) System.out.println("SK");
			else System.out.println("CY");
		}
		br.close();
	}

}
