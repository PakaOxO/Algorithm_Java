package bruteForce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

// 일곱 난쟁이 
public class BaekJoon_2309 {
	static int[] heights;
	static int[] sorted;
	static int[] arr;
	static int[] answer;
	
	static void countingSort(int max) {
		int[] cnt = new int[max + 1];
		for (int i=0; i<9; i++) {
			cnt[heights[i]]++;
		}
		int acc = 0;
		for (int i=0; i<max+1; i++) {
			acc += cnt[i];
			cnt[i] = acc;
		}
		sorted = new int[9];
		for (int i=heights.length-1; i>=0; i--) {
			sorted[cnt[heights[i]] - 1] = heights[i];
			cnt[heights[i]]--;
		}
	}
	
	static void getAnswer(int idx, int cnt, int sum) {
		if (idx > 9 || sum > 100) return;
		if (cnt > 6) {
			if (sum == 100) answer = Arrays.copyOf(arr, 7);
			return;
		}
		for (int i=idx; i<sorted.length; i++) {
			arr[cnt] = sorted[i];
			sum += sorted[i];
			getAnswer(i + 1, cnt + 1, sum);
			arr[cnt] = 0;
			sum -= sorted[i];
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		heights = new int[9];
		int max = Integer.MIN_VALUE;
		for (int i=0; i<9; i++) {
			int height = Integer.parseInt(br.readLine());
			heights[i] = height;
			if (height > max) max = height;
		}
		countingSort(max);
		
		arr = new int[7];
		answer = new int[7];
		getAnswer(0, 0, 0);
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<7; i++) {
			sb.append(answer[i] + "\n");
		}
		System.out.println(sb.toString().trim());
		br.close();
	}

}
