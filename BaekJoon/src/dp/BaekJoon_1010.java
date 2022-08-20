package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 다리 놓기
public class BaekJoon_1010 {
	
	static long factorial(int X, int bottom) {
		long result = 1;
		while (X > bottom) {
			result *= X--;
		}
		return result;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			if (N == M) {
				sb.append(1).append("\n");
				continue;
			}
			if (N == 1 || M - N == 1) {
				sb.append(M).append("\n");
				continue;
			}
			long answer = 1;
			N = (M - N < N) ? M - N : N;
			answer = factorial(M, M - N) / factorial(N, 0);
			sb.append(answer).append("\n");
		}
		System.out.print(sb);
		br.close();
	}

}
