package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// ทฮวม
public class BaekJoon_2217 {
	static int[] ropes;
	static int[] sorted;
	
	static void countingSort(int max) {
		int[] cnt = new int[max + 1];
		for (int i=0; i<ropes.length; i++) {
			cnt[ropes[i]]++;
		}
		int acc = 0;
		for (int i=0; i<max+1; i++) {
			acc += cnt[i];
			cnt[i] = acc;
		}
		sorted = new int[ropes.length];
		for (int i=ropes.length-1; i>=0; i--) {
			sorted[cnt[ropes[i]] - 1] = ropes[i];
			cnt[ropes[i]]--;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ropes = new int[N];
		int max = Integer.MIN_VALUE;
		for (int i=0; i<N; i++) {
			int rope = Integer.parseInt(br.readLine());
			ropes[i] = rope;
			if (rope > max) max = rope;
		}
		countingSort(max);
		int answer = Integer.MIN_VALUE;
		for (int i=0; i<N; i++) {
			answer = Math.max(answer, sorted[i] * (N - i));
		}
		System.out.println(answer);
		br.close();
	}

}
