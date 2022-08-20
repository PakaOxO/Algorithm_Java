package level_03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 문제 제목 붙이기
public class SWEA_7087 {
	static int[] cnt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			cnt = new int[26];
			for (int i=0; i<N; i++) {
				char c = br.readLine().charAt(0);
				if (cnt[c - 'A'] == 0) cnt[c - 'A']++;
			}
			int answer = 0;
			for (int i=0; i<26; i++) {
				if (cnt[i] == 0) break;
				answer++;
			}
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		System.out.print(sb);
		br.close();
	}

}
