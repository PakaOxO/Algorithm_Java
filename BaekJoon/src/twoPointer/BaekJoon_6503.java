package twoPointer;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 망가진 키보드
public class BaekJoon_6503 {
	static int N;
	static String str;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N;
		while (true) {
			N = Integer.parseInt(br.readLine());
			if (N == 0) break;
			int[] letter = new int[128];
			str = br.readLine();
			int left = -1, right = -1, cnt = 0, max = 0;
			int len = str.length();
			
			while (left <= right) {
				if (right == len - 1) break;
				if (cnt < N || (cnt == N && letter[str.charAt(right + 1)] > 0)) {
					right++;
					if (letter[str.charAt(right)] == 0) cnt++;
					letter[str.charAt(right)]++;
				} else {
					left++;
					letter[str.charAt(left)]--;
					if (letter[str.charAt(left)] == 0) cnt--;
				}
				max = Math.max(max, right - left);
			}
			sb.append(max).append("\n");
		}
		System.out.print(sb);
		br.close();
	}

}
