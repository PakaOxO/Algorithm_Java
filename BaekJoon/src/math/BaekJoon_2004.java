package math;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_2004, 조합 0의 개수
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 조합 공식은 n! / m! * (n - m)!
 * 	2. n, m, r에 5와 2가 몇개 들어갈 수 있는지 체크
 * 	3. 10은 2와 5의 곱이므로 2와 5의 개수중 적은 것을 답으로 리턴
 *
 */
public class BaekJoon_2004 {
	static int divide5(int num) {
		int cnt = 0;
		while (num >= 5) {
			cnt += num / 5;
			num /= 5;
		}
		return cnt;
	}
	
	static int divide2(int num) {
		int cnt = 0;
		while (num >= 2) {
			cnt += num / 2;
			num /= 2;
		}
		return cnt;
	}
	
	static int solution(int n, int m) {
		if (n == 0 || m == 0) return 0;
		int r = n - m;
		
		return Math.min(divide5(n) - (divide5(r) + divide5(m)), divide2(n) - (divide2(r) + divide2(m)));
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		System.out.println(solution(N, M));
		br.close();
	}

}
