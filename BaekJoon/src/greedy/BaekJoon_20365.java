package greedy;

import java.io.*;

/**
 * BaekJoon_20365, 블로그2
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 연속된 색은 1개의 색으로 취급하면 됐던 문제
 * 	2. 연속된 색을 1개로 카운트해 R과 B의 수 중 적은 숫자 + 1(모든 색을 다른 색으로 칠하는 횟수)하면 정답
 *
 */
public class BaekJoon_20365 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		br.close();
		
		int bCnt = 0;
		int rCnt = 0;
		char prev = str.charAt(0);
		if (prev == 'B') bCnt++;
		else rCnt++;
		
		for (int i=1; i<N; i++) {
			if (str.charAt(i) == prev) continue;
			
			if (str.charAt(i) == 'B') {
				bCnt++;
				prev = 'B';
			}
			else {
				rCnt++;
				prev = 'R';
			}
		}
		
		if (bCnt > rCnt) {
			System.out.println(rCnt + 1);
		} else {
			System.out.println(bCnt + 1);
		}
	}

}
