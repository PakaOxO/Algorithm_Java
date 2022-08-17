package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 극장 좌석
public class BaekJoon_8500 {
	private static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i=1; i<=T; i++) {
			int N = Integer.parseInt(br.readLine());
			arr = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			int sum = 0;
			int max = Integer.MIN_VALUE;
			for (int j=0; j<N; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
				sum += arr[j];
				max = Math.max(max, arr[j]);
			}
			
			sum += N + max;
			sb.append("#" + i + " " + sum + "\n");
		}
		System.out.println(sb.toString().trim());
		br.close();
	}

}
