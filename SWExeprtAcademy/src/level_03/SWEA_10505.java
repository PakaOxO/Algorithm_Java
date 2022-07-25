package level_03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 소득 불균형
public class SWEA_10505 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i=0; i<T; i++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] arr = new int[N];
			int sum = 0;
			for (int j=0; j<N; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
				sum += arr[j];
			}
			int avg = sum / N;
			int cnt = 0;
			for (int j=0; j<N; j++) {
				if (arr[j] <= avg) cnt++;
			}
			System.out.printf("#%d %d\n", i + 1, cnt);
		}
		br.close();
	}

}
