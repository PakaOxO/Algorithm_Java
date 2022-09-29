package greedy;

import java.io.*;

/**
 * BaekJoon_2138, 전구와 스위치
 * @author kevin-Arpe
 *
 */
public class BaekJoon_2138 {
	static int N;
	static char[] before, after, bCopy;
	
	static void swap(int idx, int type) {
		if (type == 1) {
			before[idx - 1] = before[idx - 1] == '0' ? '1' : '0';
			before[idx] = before[idx] == '0' ? '1' : '0';
			if (idx + 1 < N) before[idx + 1] = before[idx + 1] == '0' ? '1' : '0';
		} else {
			bCopy[idx - 1] = bCopy[idx - 1] == '0' ? '1' : '0';
			bCopy[idx] = bCopy[idx] == '0' ? '1' : '0';
			if (idx + 1 < N) bCopy[idx + 1] = bCopy[idx + 1] == '0' ? '1' : '0';
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		before = br.readLine().toCharArray();
		after = br.readLine().toCharArray();
		
		bCopy = before.clone();
		bCopy[0] = bCopy[0] == '1' ? '0' : '1';
		bCopy[1] = bCopy[1] == '1' ? '0' : '1';
		
		int cnt1 = 0;
		int cnt2 = 1;
		
		for (int i=1; i<N; i++) {
			if (after[i - 1] != before[i - 1]) {
				cnt1++;
				swap(i, 1);
			}
			
			if (after[i - 1] != bCopy[i - 1]) {
				cnt2++;
				swap(i, 2);
			}
		}
		
		if (before[N - 1] == after[N - 1]) {
			System.out.println(cnt1);
		} else if (bCopy[N - 1] == after[N - 1]) {
			System.out.println(cnt2);
		} else {
			System.out.println(-1);
		}
	}

}
