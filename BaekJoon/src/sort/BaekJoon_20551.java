package sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 마스터 배지훈의 후계자
public class BaekJoon_20551 {
	static int[] input;
	static int binarySearch(int target) {
		int left = 0;
		int right = input.length - 1;
		
		int result = -1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (input[mid] >= target) {
				if (input[mid] == target) result = mid;
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return result;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		input = new int[N];
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<N; i++) {
			input[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(input);
		for (int i=0; i<M; i++) {
			sb.append(binarySearch(Integer.parseInt(br.readLine())) + "\n");
		}
		System.out.println(sb.toString().trim());
		br.close();
	}

}
