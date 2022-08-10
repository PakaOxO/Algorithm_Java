package search;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 수 찾기
public class BaekJoon_1920 {
	static int N;
	static int[] input;
	
	static boolean binarySearch(int target) {
		int left = 0;
		int right = N - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (input[mid] >= target) {
				if (input[mid] == target) return true;
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return false;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		input = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(input);
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<M; i++) {
			if (binarySearch(Integer.parseInt(st.nextToken()))) {
				sb.append(1 + "\n");
				continue;
			}
			sb.append(0 + "\n");
		}
		System.out.println(sb.toString().trim());
		br.close();
	}

}
