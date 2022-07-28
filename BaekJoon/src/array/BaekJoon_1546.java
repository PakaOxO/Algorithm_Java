package array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 평균
public class BaekJoon_1546 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int sum = 0;
		int max = Integer.MIN_VALUE;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			int num = Integer.parseInt(st.nextToken());
			sum += num;
			if (num > max) max = num;
		}
		System.out.println((sum / (double)max) * 100 / N);
		br.close();
	}

}
