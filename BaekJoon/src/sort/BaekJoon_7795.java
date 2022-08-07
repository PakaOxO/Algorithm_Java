package sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 먹을 것인가 먹힐 것인가
public class BaekJoon_7795 {
	private static int[] arrA;
	private static int[] arrB;
	
	private static int binarySearch(int target) {
		int cnt = 0;
		int left = 0;
		int right = arrB.length - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (target <= arrB[mid]) {
				right = mid - 1;
			} else {
				cnt = (mid + 1);
				left = mid + 1;
			}
		}
		return cnt;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i=1; i<=T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			arrA = new int[N];
			arrB = new int[M];
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				arrA[j] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<M; j++) {
				arrB[j] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arrB);
			
			int answer = 0;
			for (int j=0; j<N; j++) {
				answer += binarySearch(arrA[j]);
			}
			System.out.println(answer);
		}
		br.close();
	}

}
