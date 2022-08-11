package search;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// ∞‘¿”
public class BaekJoon_1072 {
	static double binarySearch(double N, double M) {
		if (N == M) return -1;
		double left = 0;
		double right = Integer.MAX_VALUE;
		double prev = Math.floor(M * 100 / (double)N);
		double result = -1;
		while (left <= right) {
			if (prev == 99) break;
			double mid = Math.floor((left + right) / 2);
			double diff = Math.floor(((M + mid) / (double)(N + mid)) * 100) - prev;
			if (diff >= 1) {
				result = mid;
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		double N = Double.parseDouble(st.nextToken());
		double M = Double.parseDouble(st.nextToken());
		double result = binarySearch(N, M);
		System.out.printf("%.0f", result);
		br.close();
	}

}
