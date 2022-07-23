package level_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 쉬운 거스름돈
public class SWEA_1970 {
	public static int[] money = { 50000, 10000, 5000, 1000, 500, 100, 50, 10 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCnt = Integer.parseInt(br.readLine());
		for (int i=0; i<testCnt; i++) {
			int[] moneyCnt = new int[8];
			int change = Integer.parseInt(br.readLine());
			int idx = 0;
			while (change > 9) {
				int cnt = change / money[idx];
				if (cnt > 0) {
					change -= (money[idx] * cnt);
					moneyCnt[idx] += cnt;
				} else {
					idx++;
				}
			}
			System.out.println("#" + (i + 1));
			String result = "";
			for (int j=0; j<moneyCnt.length; j++) {
				result += (moneyCnt[j] + " ");
			}
			System.out.println(result.trim());
		}
		br.close();
	}

}
