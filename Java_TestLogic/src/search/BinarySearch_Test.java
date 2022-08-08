package search;

import java.util.Arrays;

public class BinarySearch_Test {
	
	public static int binarySearch(int[] arr, int target) {
		int left = 0;
		int right = arr.length;
		while (left < right) {
			int mid = (left + right) / 2;
			if (arr[mid] >= target) {
				if (arr[mid] == target) return mid;
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 4, 3, 6, 4, 7, 89, 565 ,3, 25, 58, 34, 2 };
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		System.out.println(binarySearch(arr, 1));
		System.out.println(binarySearch(arr, 565));
		System.out.println(binarySearch(arr, 65));
	}

}
