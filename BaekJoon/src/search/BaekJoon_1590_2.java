package search;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 캠프가는 영식
public class BaekJoon_1590_2 {
	static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		answer = Integer.MAX_VALUE;
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int I = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			for (int j=0; j<C; j++) {
				if (I*j + S < T) continue;
				answer = Math.min(answer, (I*j + S) - T);
				break;
			}
		}
		if (answer == Integer.MAX_VALUE) answer = -1;
		System.out.println(answer);
		br.close();
	}

}
