package sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

// APC는 왜 서브태스크 대회가 되었을까?
public class BaekJoon_17224 {
	static int[][] tasks;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		tasks = new int[N][];
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int[] task = { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };
			tasks[i] = task;
		}
		Arrays.sort(tasks, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[1] == o2[1]) {
					return o1[0] - o2[0];
				} else {
					return o1[1] - o2[1];
				}
			}
		});
		int score = 0;
		int cnt = 0;
		for (int i=0; i<N; i++) {
			if (cnt == K) break;
			if (tasks[i][1] <= L) {
				score += 140;
				cnt++;
			} else if (tasks[i][0] <= L) {
				score += 100;
				cnt++;
			}
		}
		System.out.println(score);
		br.close();
	}

}
