package implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 경비원 (다른 풀이)
public class BaekJoon_2564_2 {
	static int[] dists;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int dAround = 2 * (W + H);
		int N = Integer.parseInt(br.readLine());
		dists = new int[N+1];
		for (int i=0; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			if (dir == 1) {
				dists[i] = dist;
			} else if (dir == 2) {
				dists[i] = 2 * W + H - dist;
			} else if (dir == 3) {
				dists[i] = dAround - dist;
			} else {
				dists[i] = W + dist;
			}
		}
		int sum = 0;
		for (int i=0; i<N; i++) {
			int d = (dists[N] >= dists[i]) ? dists[N] - dists[i] : dists[i] - dists[N];
			sum += Math.min(d, dAround - d);
		}
		System.out.println(sum);
		br.close();
	}

}
