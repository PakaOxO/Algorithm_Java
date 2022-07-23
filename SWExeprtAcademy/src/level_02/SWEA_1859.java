package level_02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백만장자 프로젝트
public class SWEA_1859 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i=0; i<T; i++) {
			int N = Integer.parseInt(br.readLine());
			int arr[] = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			
			int idx = 0;
			double sum = 0;
			while (idx < N) {
				int max = Integer.MIN_VALUE;
				int idxOfMax = 0;
				for (int j=idx; j<N; j++) {
					int num = arr[j];
					if (num >= max) {
						max = num;
						idxOfMax = j;
					}
				}
				
				for (int j=idx; j<=idxOfMax; j++) {
					sum += (max - arr[j]);
				}
				idx = idxOfMax + 1;
			}
			System.out.printf("#%d %.0f\n", i + 1, sum);
		}
		br.close();
	}

}
