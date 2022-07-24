package level_03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 준환이의 운동관리
public class SWEA_3431 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i=0; i<T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(st.nextToken());
			int U = Integer.parseInt(st.nextToken());
			int X = Integer.parseInt(st.nextToken());
			
			int result;
			if (X < L) {
				result = L - X;
			} else if (X > U) {
				result = -1;
			} else {
				result = 0;
			}
			System.out.printf("#%d %d\n", i + 1, result);
		}
	}

}
