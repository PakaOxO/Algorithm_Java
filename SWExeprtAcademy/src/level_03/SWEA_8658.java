package level_03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Summation
public class SWEA_8658 {
	public static int summation(int num) {
		int sum = 0;
		while (num > 0) {
			sum += (num % 10);
			num /= 10;
		}
		return sum;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i=1; i<=T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			for (int j=0; j<10; j++) {
				int sum = summation(Integer.parseInt(st.nextToken()));
				if (sum < min) min = sum;
				if (sum > max) max = sum;
			}
			System.out.printf("#%d %d %d\n", i, max, min);
		}
	}

}
