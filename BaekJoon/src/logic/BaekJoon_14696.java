package logic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 딱지놀이
public class BaekJoon_14696 {
	static int[] cntA;
	static int[] cntB;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int i=0; i<T; i++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			cntA = new int[4];
			for (int j=0; j<N; j++) {
				cntA[Integer.parseInt(st.nextToken()) - 1]++;
			}
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			cntB = new int[4];
			for (int j=0; j<M; j++) {
				cntB[Integer.parseInt(st.nextToken()) - 1]++;
			}
			
			for (int j=3; j>=0; j--) {
				if (cntA[j] > cntB[j]) {
					sb.append("A\n");
					break;
				}
				else if (cntA[j] < cntB[j]) {
					sb.append("B\n");
					break;
				}
				else {
					if (j == 0) sb.append("D\n");
				}
			}
		}
		System.out.print(sb);
		br.close();
	}

}
