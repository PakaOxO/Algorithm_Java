package search;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 캠프가는 영식
public class BaekJoon_1590 {
	static int answer;
	static int lostBusCnt;
	
	static void binarySearch(int T, int S, int diff, int left, int right) {
		if (S + (diff * right) < T) {
			lostBusCnt++;
			return;
		}
		while (left <= right) {
			int mid = (left + right) / 2;
			if (S + (mid * diff) <= T) {
				if (T == S + (mid * diff)) {
					answer = 0;
					return;
				}
				left = mid + 1;
			} else {
				answer = Math.min(answer, S + (mid * diff) - T);
				right = mid - 1;
			}
		}
	}

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
			if (answer != 0) binarySearch(T, S, I, 0, C - 1);
		}
		if (lostBusCnt == N) answer = -1;
		System.out.println(answer);
		br.close();
	}

}
