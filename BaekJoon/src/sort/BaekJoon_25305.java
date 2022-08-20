package sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon_25305 {
	static int[] scores;
	static int[] sorted;
	
	// 카운팅 정렬 연습
	static void countingSort(int max) {
		int[] cnt = new int[max + 1];
		for (int i=0; i<scores.length; i++) {
			cnt[scores[i]]++;
		}
		int acc = 0;
		for (int i=0; i<max+1; i++) {
			acc += cnt[i];
			cnt[i] = acc;
		}
		sorted = new int[scores.length];
		for (int i=scores.length-1; i>=0; i--) {
			sorted[cnt[scores[i]] - 1] = scores[i];
			cnt[scores[i]]--;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		scores = new int[N];
		
		st = new StringTokenizer(br.readLine());
		int max = Integer.MIN_VALUE;
		for (int i=0; i<N; i++) {
			int score = Integer.parseInt(st.nextToken());
			scores[i] = score;
			if (score > max) max = score;
		}
		countingSort(max);
		System.out.println(sorted[N-K]);
		br.close();
	}

}
