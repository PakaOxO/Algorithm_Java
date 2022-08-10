package search;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

// 숫자 카드
public class BaekJoon_10815 {
	static int[] arr;
	
	
	static boolean binarySearch(int left, int right, int target) {
		if (left > right) return false;
		
		int mid = (left + right) / 2;
		if (arr[mid] == target) {
			return true;
		}
		if (arr[mid] > target) {
			return binarySearch(left, mid-1, target);
		} else {
			return binarySearch(mid+1, right, target);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[N];
		for (int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<M; i++) {
			if (binarySearch(0, N-1, Integer.parseInt(st.nextToken()))) {
				sb.append(1 + " ");
			} else sb.append(0 + " ");
		}
		System.out.println(sb.toString().trim());
		br.close();
	}

}
