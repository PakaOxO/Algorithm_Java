package level_03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 농작물 수확하기
public class SWEA_2805 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int i=1; i<=T; i++) {
			int N = Integer.parseInt(br.readLine());
			int mid = N / 2;
			int sum = 0;
			for (int j=0; j<N; j++) {
				String[] input = br.readLine().split("");
				int from = (j <= mid) ? mid - j : j - mid;
				int to = (j <= mid) ? mid + j : (N - 1) - (j - mid);
				
				for (int k=from; k<=to; k++) {
					sum += Integer.parseInt(input[k]);
				}
			}
			sb.append("#" + i + " " + sum + "\n");
		}
		System.out.println(sb.toString().trim());
	}
}
