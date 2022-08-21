package sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 알고리즘 수업 - 선택 정렬 2
public class BaekJoon_23882 {
	static int[] arr;
	static int N, K;
	static int cnt;
	
	static void swap(int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	static void selectionSort() {
		for (int i=N-1; i>0; i--) {
			int maxIdx = i;
			for (int j=i; j>=0; j--) {
				if (arr[j] > arr[maxIdx]) maxIdx = j;
			}
			if (maxIdx != i) {
				swap(i, maxIdx);
				cnt++;
			}
			if (cnt == K) break;
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
		
		if (cnt < K) {
			System.out.println(-1);
			return;
		}
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<N; i++) {
			sb.append(arr[i]);
			if (i < N - 1) sb.append(" ");
		}
		System.out.println(sb);
		br.close();
	}

}
