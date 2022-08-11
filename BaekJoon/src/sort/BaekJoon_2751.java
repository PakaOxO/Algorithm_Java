package sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 수 정렬하기 2
public class BaekJoon_2751 {
	static int[] input;
	
	static void countingSort(int min, int max) {
		int[] cnt = new int[max - min + 1];
		for (int i=0; i<input.length; i++) {
			cnt[input[i] - min]++;
		}
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<cnt.length; i++) {
			for (int j=0; j<cnt[i]; j++) {
				sb.append(i + min + "\n");
			}
		}
		System.out.println(sb.toString().trim());
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		input = new int[N];
		for (int i=0; i<N; i++) {
			input[i] = Integer.parseInt(br.readLine());
			if (input[i] > max) max = input[i];
			if (input[i] < min) min = input[i];
		}
		countingSort(min, max);
	}

}
