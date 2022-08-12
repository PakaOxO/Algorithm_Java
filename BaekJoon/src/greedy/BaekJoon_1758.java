package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 알바생 강호
public class BaekJoon_1758 {
	static int[] tips;
	static int[] sorted;
	
	static void countingSort(int max) {
		int[] cnt = new int[max + 1];
		for (int i=0; i<tips.length; i++) {
			cnt[tips[i]]++;
		}
		int acc = 0;
		for (int i=0; i<max+1; i++) {
			acc += cnt[i];
			cnt[i] = acc;
		}
		sorted = new int[tips.length];
		for (int i=tips.length-1; i>=0; i--) {
			sorted[sorted.length - 1 - (cnt[tips[i]] - 1)] = tips[i];
			cnt[tips[i]]--;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		tips = new int[N];
		int max = Integer.MIN_VALUE;
		for (int i=0; i<N; i++) {
			int tip = Integer.parseInt(br.readLine());
			tips[i] = tip;
			if (tip > max) max = tip;
		}
		countingSort(max);
		long answer = 0;
		for (int i=0; i<N; i++) {
			int tip = sorted[i] - i;
			if (tip <= 0) break;
			answer += tip;
		}
		System.out.println(answer);
		br.close();
	}

}
