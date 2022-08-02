package level_03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 민석이의 과제 체크하기
public class SWEA_5431 {
	public static boolean[] doNotHW;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int i=1; i<=T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			doNotHW = new boolean[N];
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<K; j++) {
				doNotHW[Integer.parseInt(st.nextToken()) - 1] = true;
			}
			
			answer.append("#" + i + " ");
			for (int j=0; j<N; j++) {
				if (!doNotHW[j]) answer.append(j+1 + " ");
			}
			answer.append("\n");
		}
		System.out.println(answer.toString().trim());
		br.close();
	}

}
