package level_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 숫자를 정렬하자 (병합 정렬)
public class SWEA_1966 {
	public static String[] mergeSort(String[] arr) {
		int len = arr.length;
		if (len < 2) return arr;
		
		int mid = len / 2;
		String[] left = Arrays.copyOfRange(arr, 0, mid);
		String[] right = Arrays.copyOfRange(arr, mid, len);
		
		return merge(len, mergeSort(left), mergeSort(right));
	}
	
	public static String[] merge(int len, String[] left, String[] right) {
		String[] merged = new String[len];
		
		int idx = 0;
		int leftIdx = 0;
		int rightIdx = 0;
		// 값 비교해 채우기
		while (leftIdx < left.length && rightIdx < right.length) {
			if (Integer.parseInt(left[leftIdx]) <= Integer.parseInt(right[rightIdx])) {
				merged[idx++] = left[leftIdx++];
			} else {
				merged[idx++] = right[rightIdx++];
			}
		}
		
		// 남은 항목
		while (idx < len) {	
			if (leftIdx < left.length) {
				merged[idx++] = left[leftIdx++];
			}
			if (rightIdx < right.length) {
				merged[idx++] = right[rightIdx++];
			}
		}
		
		return merged;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCnt = Integer.parseInt(br.readLine());
		for (int i=0; i<testCnt; i++) {
			int len = Integer.parseInt(br.readLine());
			String[] input = br.readLine().split(" ");
			String[] sorted = mergeSort(input);
			
			System.out.printf("#%d %s\n", i + 1, String.join(" ", sorted));
		}
		
	}

}
