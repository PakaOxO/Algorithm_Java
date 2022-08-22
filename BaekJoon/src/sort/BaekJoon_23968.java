package sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 알고리즘 수업 - 버블 정렬 1
public class BaekJoon_23968 {
	static int N, K;
	static int[] arr;
	static int cnt;
	static int a, b;
	
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
				if (cnt == K) {
					a = arr[j];
					b = arr[j+1];
					break;
				}
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
		bubbleSort();
		if (cnt < K) System.out.println(-1);
		else System.out.println(a + " " + b);
		br.close();
	}

}
