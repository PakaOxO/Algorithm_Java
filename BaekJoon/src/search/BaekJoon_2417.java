package search;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 정수 제곱근
public class BaekJoon_2417 {
	static long answer;
	
	static void binarySearch(long N) {
		long left = 0;
		long right = N;
		while (left <= right) {
			long mid = (left + right) / 2;
			long cal = (long)Math.pow(mid, 2);
			if (cal < N) {
				left = mid + 1;
			} else {
				answer = Math.min(answer, mid);
				right = mid - 1;
			}
		}
		return;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long N = Long.parseLong(br.readLine());
		answer = Long.MAX_VALUE;
		binarySearch(N);
		System.out.println(answer);
		br.close();
	}

}
