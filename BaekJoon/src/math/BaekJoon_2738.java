package math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 행렬 덧셈
public class BaekJoon_2738 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] sumArr = new int[N][M];
		for (int i=0; i<(N*2); i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<M; j++) {
				sumArr[i%N][j] += Integer.parseInt(st.nextToken());
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				sb.append(sumArr[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString().trim());
		br.close();
	}

}
