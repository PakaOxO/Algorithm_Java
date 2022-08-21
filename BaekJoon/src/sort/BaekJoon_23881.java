package sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 알고리즘 수업 - 선택 정렬 1
public class BaekJoon_23881 {
	static int N, K;
	static int[] arr;
	static int cnt;
	static int a, b;
	
	static void swap(int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		cnt++;
		if (cnt == K) {
			if (arr[i] > arr[j]) {
				a = arr[j];
				b = arr[i];
			} else {
				b = arr[j];
				a = arr[i];
			}
		}
	}
	
	static void selectionSort() {
		for (int i=N-1; i>=1; i--) {
			int max = Integer.MIN_VALUE;
			int maxIdx = -1;
			for (int j=i; j>=0; j--) {
				if (arr[j] > max) {
					max = arr[j];
					maxIdx = j;
				}
			}
			if (maxIdx != i) {
				swap(i, maxIdx);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		selectionSort();
		if (cnt < K) System.out.println(-1);
		else System.out.println(a + " " + b);
		br.close();
	}

}
