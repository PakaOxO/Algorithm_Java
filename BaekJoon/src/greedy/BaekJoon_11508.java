package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 2+1 ºº¿œ
public class BaekJoon_11508 {
	static int[] prices;
	static int[] sorted;

	static void countingSort(int max) {
		int[] cnt = new int[max + 1];
		for (int i=0; i<prices.length; i++) {
			cnt[prices[i]]++;
		}
		int acc = 0;
		for (int i=0; i<max+1; i++) {
			acc += cnt[i];
			cnt[i] = acc;
		}
		sorted = new int[prices.length];
		for (int i=prices.length-1; i>=0; i--) {
			sorted[sorted.length - 1 - (cnt[prices[i]] - 1)] = prices[i];
			cnt[prices[i]]--;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		prices = new int[N];
		int max = Integer.MIN_VALUE;
		for (int i=0; i<N; i++) {
			int price = Integer.parseInt(br.readLine());
			prices[i] = price;
			if (price > max) max = price;
		}
		countingSort(max);
		long answer = 0;
		for (int i=0; i<N; i+=3) {
			if (i + 2 < N) {
				answer += sorted[i] + sorted[i+1];
			} else {
				while (i < N) {
					answer += sorted[i++];
				}
			}
		}
		System.out.println(answer);
		br.close();
	}

}
