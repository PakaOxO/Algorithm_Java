package math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 참외밭 
public class BaekJoon_2477 {
	static int[] dists;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = 6;
		dists = new int[6];
		int max = Integer.MIN_VALUE;
		int maxIdx = -1;
		for (int i=0; i<M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			st.nextToken();
			int dist = Integer.parseInt(st.nextToken());
			dists[i] = dist;
			if (dist > max) {
				max = dist;
				maxIdx = i;
			}
		}
		int prev = (maxIdx - 1 + M) % M;
		int next = (maxIdx + 1) % M;
		int answer = 0;
		if (dists[prev] > dists[next]) {
			answer = (max * dists[prev]) - (dists[(next + 1) % M] * dists[(next + 2) % M]);
		} else {
			answer = (max * dists[next]) - (dists[(prev - 1 + M) % M] * dists[(prev - 2 + M) % M]);
		}
		System.out.println(answer * N);
		br.close();
	}

}
