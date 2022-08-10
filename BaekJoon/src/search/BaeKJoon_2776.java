package search;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 암기왕
public class BaeKJoon_2776 {
	static int[] input;
	static int N;
	
	static boolean binarySearch(int target) {
		int left = 0;
		int right = N - 1;
		
		while (left <= right) {
			int mid = (left + right) / 2;
			int curr = input[mid];
			if (curr > target) {
				right = mid - 1;
			} else {
				if (curr == target) return true;
				left = mid + 1;
			}
		}
		return false;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int i=0; i<T; i++) {
			N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			input = new int[N];
			for (int j=0; j<N; j++) {
				input[j] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(input);
			int M = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<M; j++) {
				if (binarySearch(Integer.parseInt(st.nextToken()))) sb.append("1\n");
				else sb.append("0\n");
			}
		}
		System.out.println(sb.toString().trim());
		br.close();
	}

}
