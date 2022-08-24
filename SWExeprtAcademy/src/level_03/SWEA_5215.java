package level_03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 햄버거 다이어트
public class SWEA_5215 {
	static int N, L;
	static int[][] foods;
	static int answer;
	
	static void getFood(int start, int tastes, int calories) {
		if (calories > L) return;
		answer = Math.max(answer, tastes);
		
		for (int i=start; i<N; i++) {
			getFood(i + 1, tastes + foods[i][0], calories + foods[i][1]);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			foods = new int[N][2];
			for (int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				foods[i][0] = Integer.parseInt(st.nextToken());
				foods[i][1] = Integer.parseInt(st.nextToken());
			}
			answer = 0;
			getFood(0, 0, 0);
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		System.out.print(sb);
		br.close();
	}

}
