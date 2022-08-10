package search;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 어두운 굴다리
public class BaekJoon_17266 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int max = Integer.MIN_VALUE;
		StringTokenizer st = new StringTokenizer(br.readLine());
		int prev = 0;
		for (int i=0; i<M; i++) {
			int input = Integer.parseInt(st.nextToken());
			if (M == 1) {
				max = Math.max(N - input, input);
				break;
			}
			int gap = ( (input - prev) / 2 * 2) < ((input - prev)) ? (input - prev) / 2 + 1: (input - prev) / 2;
			if (i == M - 1) gap = Math.max(N - input, gap);
			else if (i == 0) gap = input;
			max = Math.max(gap, max);
			prev = input;
		}
		System.out.println(max);
	}

}
