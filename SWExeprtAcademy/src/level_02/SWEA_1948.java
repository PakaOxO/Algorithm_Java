package level_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 날짜 계산기
public class SWEA_1948 {
	private static int[] lastDate = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCnt = Integer.parseInt(br.readLine().trim());
		for (int i=0; i<testCnt; i++) {
			result = 0;
			String[] input = br.readLine().trim().split(" ");
			int month1 = Integer.parseInt(input[0]);
			int date1 = Integer.parseInt(input[1]);
			int month2 = Integer.parseInt(input[2]);
			int date2 = Integer.parseInt(input[3]);
			
			if (month1 == month2) {
				result = date2 - date1 + 1;
			} else {
				result += lastDate[month1 - 1] - date1 + 1;
				for (int j=month1 + 1; j<month2; j++) {
					result += lastDate[j - 1];
				}
				result += date2;
			}
			
			System.out.printf("#%d %d\n", i + 1, result);
		}
	}

}
