package bruteForce;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_18312, 시각
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 브루트포스로 1초씩 시각을 늘려가며 숫자 K가 포함되어있는지 체크
 * 	2. 시각을 늘리는 로직과 현재 시각에 K가 들어가 있는 메서드 구현 필요.
 *
 */
public class BaekJoon_18312 {
	static int cnt;
	static void checkTime(int h, int m, int s, int K) {
		if (K == 0 && (h <= 10 || m <= 10 || s <= 10)) {
			cnt++;
			return;
		}
		
		while (h > 0) {
			if (K == h % 10) {
				cnt++;
				return;
			}
			h /= 10;
		}
		
		while (m > 0) {
			if (K == m % 10) {
				cnt++;
				return;
			}
			m /= 10;
		}
		
		while (s > 0) {
			if (K == s % 10) {
				cnt++;
				return;
			}
			s /= 10;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int h = 0;
		int m = 0;
		int s = -1;
		
		cnt = 0;
		while (!(h == N && m == 59 && s == 59)) {
			s++;
			if (s == 60) {
				m++;
				s = 0;
			}
			if (m == 60) {
				h++;
				m = 0;
			}
			checkTime(h, m, s, K);
		}
		
		System.out.println(cnt);
		br.close();
	}

}
