package level_03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 쥬스 나누기
public class SWEA_5601 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i=1; i<=T; i++) {
			int N = Integer.parseInt(br.readLine());
			StringBuilder sb = new StringBuilder();
			for (int j=0; j<N; j++) {
				sb.append(String.format("%d/%d ", 1, N));
			}
			System.out.printf("#%d %s\n", i, sb.toString());
		}
		br.close();
	}

}
