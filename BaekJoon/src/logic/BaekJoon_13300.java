package logic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 방 배정
public class BaekJoon_13300 {
	static StringTokenizer st;
	static int[][] cnt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		cnt = new int[2][6];
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			cnt[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken()) - 1]++;
		}
		int answer = 0;
		for (int i=0; i<6; i++) {
			answer = (cnt[0][i] % K == 0) ? answer + (cnt[0][i] / K) : answer + (cnt[0][i] / K) + 1;
			answer = (cnt[1][i] % K == 0) ? answer + (cnt[1][i] / K) : answer + (cnt[1][i] / K) + 1;
		}
		System.out.println(answer);
		br.close();
	}

}
