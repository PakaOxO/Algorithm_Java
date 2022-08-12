package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// ATM
public class BaekJoon_11399 {
	static int[] time;
	static int[] sorted;

	static void countingSort(int max) {
		int[] cnt = new int[max + 1];
		for (int i=0; i<time.length; i++) {
			cnt[time[i]]++;
		}
		int acc = 0;
		for (int i=0; i<max+1; i++) {
			acc += cnt[i];
			cnt[i] = acc;
		}
		sorted = new int[time.length];
		for (int i=0; i<time.length; i++) {
			sorted[cnt[time[i]] - 1] = time[i];
			cnt[time[i]]--;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int max = Integer.MIN_VALUE;
		time = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			int input = Integer.parseInt(st.nextToken());
			time[i] = input;
			if (input > max) max = input;
		}
		countingSort(max);
		long acc = 0;
		long answer = 0;
		for (int i=0; i<sorted.length; i++) {
			acc += sorted[i];
			answer += acc;
		}
		System.out.println(answer);
		br.close();
	}

}
