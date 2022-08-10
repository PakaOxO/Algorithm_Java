package sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

// 통계학
public class BaekJoon_2108 {
	static int[] input;
	static int[] cnt;
	
	static double avg;
	static int mid;
	static int freq;
	static int range;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		input = new int[N];
		avg = 0;
		cnt = new int[8001];
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int i=0; i<N; i++) {
			input[i] = Integer.parseInt(br.readLine());
			avg += input[i];
			if (input[i] > max) max = input[i];
			if (input[i] < min) min = input[i];
		}
		Arrays.sort(input);
		
		for (int i=0; i<input.length; i++) {
			cnt[input[i]+4000]++;
		}
		
		int cMax = 0;
		for (int i=0; i<cnt.length; i++) {
			if (cnt[i] > cMax) {
				cMax = cnt[i];
			}
		}
		int cMaxIdx = 0;
		int maxCnt = 0;
		for (int i=0; i<cnt.length; i++) {
			if (cnt[i] == cMax) {
				cMaxIdx = i;
				maxCnt++;
				if (maxCnt == 2) break;
			}
		}
		
		avg = (int)Math.round((double)avg / N);
		mid = input[N/2];
		freq = cMaxIdx - 4000;
		range = (max - min);
		System.out.printf("%.0f\n", avg);
		System.out.println(mid);
		System.out.println(freq);
		System.out.println(range);
	}

}
