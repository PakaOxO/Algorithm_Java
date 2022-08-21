package sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 영화 평가
public class BaekJoon_23278 {
	static int[] score;
	static int[] sorted;
	
	static void countingSort(int max) {
		int[] cnt = new int[max + 1];
		for (int i=0; i<score.length; i++) {
			cnt[score[i]]++;
		}
		int acc = 0;
		for (int i=0; i<max+1; i++) {
			acc += cnt[i];
			cnt[i] = acc;
		}
		sorted = new int[score.length];
		for (int i=score.length-1; i>=0; i--) {
			sorted[cnt[score[i]] - 1] = score[i];
			cnt[score[i]]--;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		
		score = new int[N];
		int max = 0;
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			int s = Integer.parseInt(st.nextToken());
			score[i] = s;
			if (s > max) max = s;
		}
		
		countingSort(max);
		double avg = 0;
		for (int i=L; i<N-H; i++) {
			avg += sorted[i];
		}
		System.out.println(avg / (N - L - H));
		br.close();
	}

}
