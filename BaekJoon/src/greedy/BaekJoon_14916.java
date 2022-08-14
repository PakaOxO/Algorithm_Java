package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 거스름돈
public class BaekJoon_14916 {
	
	static int[] change(int N) {
		int[] cnt = new int[2];
		
		while (N > 0) {
			if (N / 5 > 0) {
				cnt[0] += N / 5;
				N = N % 5;
			}
			if (N % 2 > 0 && cnt[0] > 0) {
				cnt[0]--;
				cnt[1]++;
				N += 3;
			} else {
				if (cnt[0] == 0 && N % 2 != 0) {
					cnt[0] = -1;
					cnt[1] = -1;
					break;
				}
				cnt[1] += N / 2;
				break;
			}
		}
		return cnt;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] result = change(N);
		
		if (result[0] == -1) System.out.println(-1);
		else System.out.println(result[0] + result[1]);
	}

}
