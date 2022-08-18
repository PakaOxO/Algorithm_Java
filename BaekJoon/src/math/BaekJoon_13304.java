package math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// πÊ πË¡§
public class BaekJoon_13304 {
	static int[][] cnt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int answer = 0;
		cnt = new int[3][2];
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int g = Integer.parseInt(st.nextToken());
			int c = (Integer.parseInt(st.nextToken())-1)/2;
			if (c == 0) g = 0;
			if (cnt[c][g] == 0) answer++;
			cnt[c][g]++;
			if (cnt[c][g] == K) {
				cnt[c][g] = 0;
			}
		}
		System.out.println(answer);
		br.close();
	}

}
