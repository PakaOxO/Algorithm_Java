package level_03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 부먹왕국의 차원 관문
public class SWEA_7964 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int D = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			int cnt = 0;
			int answer = 0;
			for (int i=0; i<N; i++) {
				if (Integer.parseInt(st.nextToken()) != 0) {
					cnt = 0;
					continue;
				}
				cnt++;
				if (cnt == D) {
					cnt = 0;
					answer++;
				}
			}
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		System.out.print(sb);
		br.close();
	}

}
