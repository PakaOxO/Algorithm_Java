package sort;

import java.util.Arrays;

class SelectionSort {
	int[] arr;
	int N;
	
	public void swap(int left, int right) {
		int temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp;
	}
	
	public int[] sort(int[] arr, int type) {
		this.arr = arr;
		int N = this.arr.length;
		
		for (int i=0; i<N-1; i++) {
			if (type == 0) {
				int max = Integer.MIN_VALUE;
				int maxIdx = 0;
				for (int j=0; j<=N-1-i; j++) {
					if (this.arr[j] > max) {
						max = this.arr[j];
						maxIdx = j;
					}
					if (j == N-1-i) swap(maxIdx, j);
				}
			} else if (type == 1) {
				int min = Integer.MAX_VALUE;
				int minIdx = 0;
				for (int j=0; j<=N-1-i; j++) {
					if (this.arr[j] < min) {
						min = this.arr[j];
						minIdx = j;
					}
					if (j == N-1-i) swap(minIdx, j);
				}
			} else {
				System.out.println("잘못된 입력");
			}
		}
		return this.arr;
	}
}

public class SelectionSort_Test {

	public static void main(String[] args) {
		int[] arr = { 2, 45, 7, 4, 2, 6, 78, 4, 2, 1 };
		SelectionSort i = new SelectionSort();
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(i.sort(arr, 1)));
	}

}
