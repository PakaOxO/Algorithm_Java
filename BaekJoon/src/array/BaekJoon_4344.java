package array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 평균은 넘겠지
public class BaekJoon_4344 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i=1; i<=T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int[] arr = new int[N];
			int sum = 0;
			for (int j=0; j<N; j++) {
				int num = Integer.parseInt(st.nextToken());
				arr[j] = num;
				sum += num;
			}
			int cnt = 0;
			for (int j=0; j<N; j++) {
				if (arr[j] > sum / N) cnt++;
			}
			sb.append(String.format("%.3f", (cnt / (double)N) * 100) + "%\n");
		}
		System.out.println(sb.toString().trim());
		br.close();
	}

}
