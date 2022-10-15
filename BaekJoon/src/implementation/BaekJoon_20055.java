package implementation;

import java.io.*;
import java.util.*;

// 컨베이어 벨트
public class BaekJoon_20055 {
	static int[] cBelt;
	static boolean[] robots;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		cBelt = new int[N * 2];
		robots = new boolean[N*2];
		for (int i=0; i<N*2; i++) {
			cBelt[i] = Integer.parseInt(st.nextToken());
		}
		
		int pointer = 0;
		int end = N - 1;
		int cnt = 0;
		int process = 1;
		
		while (true) {
			
			// 과정 1
			pointer = ( pointer - 1 < 0 ) ? 2 * N - 1 : pointer - 1;
			end = (pointer + N - 1) % (2 * N);
			
			if (robots[end]) {
				robots[end] = false;
			}
			
			// 과정 2
			int idx = ( end - 1 < 0 ) ? 2 * N - 1 : end - 1;
			while (true) {
				int next = (idx + 1) % (2 * N);
				if (robots[idx] && !robots[next] && cBelt[next] > 0) {
					cBelt[next]--;
					if (next != end) robots[next] = true;
					robots[idx] = false;
					
					if (cBelt[next] == 0) {
						cnt++;
					}
				}
				if (idx == pointer) break;
				idx = ( idx - 1 < 0 ) ? 2 * N - 1 : idx - 1;
			}
			
			
			// 과정 3
			if (!robots[pointer] && cBelt[pointer] > 0) {
				robots[pointer] = true;
				cBelt[pointer]--;
				
				if (cBelt[pointer] == 0) {
					cnt++;
				}
			}
			
			if (cnt >= K) break;
			process++;
		}
		System.out.println(process);
		br.close();
	}

}
