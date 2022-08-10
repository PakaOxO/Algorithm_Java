package sort;

import java.util.Arrays;

public class CountingSort_Test {
	static int[] arr = { 3, 6 ,7 , 4, 7, 4, 2, 6, 8, 4, 3, 4, 4, 1, 1 };
	static int max;
	
	static void countingSort() {
		int N = arr.length;
		max = Integer.MIN_VALUE;
		for (int i=0; i<N; i++) {
			if (arr[i] > max) max = arr[i];
		}
		
		int[] cnt = new int[max+1];
		for (int i=0; i<N; i++) {
			cnt[arr[i]]++;
		}
		
		int acc = 0;
		for (int i=0; i<max+1; i++) {
			acc += cnt[i];
			cnt[i] = acc;
		}
		System.out.println(Arrays.toString(cnt));
		int[] result = new int[N];
		for (int i=N-1; i>=0; i--) {
			result[cnt[arr[i]] - 1] = arr[i];
			cnt[arr[i]]--;
		}
		System.out.println(Arrays.toString(result));
	}

	public static void main(String[] args) {
		countingSort();
	}

}
