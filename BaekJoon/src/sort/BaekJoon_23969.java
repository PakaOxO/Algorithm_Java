package sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 알고리즘 수업 - 버블 정렬 2
public class BaekJoon_23969 {
	static int N, K;
	static int[] arr;
	static int cnt;
	
	static void swap(int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	static void bubbleSort() {
		cnt = 0;
		for (int i=N-1; i>0; i--) {
			for (int j=0; j<i; j++) {
				if (arr[j] > arr[j+1]) {
					swap(j, j+1);
					cnt++;
				}
				if (cnt == K) return;
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
		bubbleSort();
		
		StringBuilder sb = new StringBuilder();
		if (cnt < K) sb.append(-1);
		else {
			for (int i=0; i<N; i++) {
				sb.append(arr[i]);
				if (i < N - 1) sb.append(" ");
			}
		}
		System.out.println(sb);
		br.close();
	}

}
