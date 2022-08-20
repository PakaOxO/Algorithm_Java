package sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 점수 집계
public class BaekJoon_9078 {
	static int[] scores;
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc=0; tc<T; tc++) {
			scores = new int[5];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i=0; i<5; i++) {
				scores[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(scores);
			if (scores[3] - scores[1] >= 4) sb.append("KIN");
			else sb.append(scores[1]+scores[2]+scores[3]);
			sb.append("\n");
		}
		System.out.print(sb);
		br.close();
	}

}
