package greedy;

import java.io.*;
import java.util.*;

// 라면 사기 (Large)
public class BaekJoon_18186 {
	static int N, B, C;
	static int[] cnt;
	static long price;
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		cnt = new int[N];
		int acc = 0;
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			cnt[i] = Integer.parseInt(st.nextToken());
			acc += cnt[i];
		}
		
		int idx = 0;
		if (B > C) {
			while (idx < N) {
				if (cnt[idx] > 0) {
					int min = Integer.MAX_VALUE;
					if (idx + 1 < N && cnt[idx + 1] > 0) {
						if (idx + 2 < N && cnt[idx + 2] > 0) {
							if (cnt[idx + 1] > cnt[idx + 2]) {
								min = Math.min(cnt[idx], cnt[idx + 1] - cnt[idx + 2]);
								price += (B + C) * min;
								cnt[idx] -= min;
								cnt[idx + 1] -= min;
								continue;
							}
							min = Math.min(cnt[idx], Math.min(cnt[idx + 1], cnt[idx + 2]));
							price += (B + C + C) * min;
							cnt[idx] -= min;
							cnt[idx + 1] -= min;
							cnt[idx + 2] -= min;
							continue;
						}
						min = Math.min(cnt[idx], cnt[idx + 1]);
						price += (B + C) * min;
						cnt[idx] -= min;
						cnt[idx + 1] -= min;
						continue;
					}
					price += B * cnt[idx];
					cnt[idx] = 0;
				}
				idx++;
			}
		} else {
			price += B * acc;
		}
		System.out.println(price);
		br.close();
	}

}
