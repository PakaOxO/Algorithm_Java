package implementation;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_2877, 4와 7 
 * @author kevin-Arpe 
 * 
 * Sketch Idea
 * 	1. 메모리를 작게 줬기 때문에 완탐은 불가 
 * 	2. 규칙성을 발견했는데 나올 수 있는 숫자 조합을 작은 수부터 나열하고 2, 4, 8, 16개씩 쪼갰을 때 각 영역에서 절반으로 갈 때마다 숫자가 결정
 * 		2.1 각 영역(2, 4, 8, 16...)은 2의 K제곱인데 K가 해당 숫자 조합의 자리수를 의미 (2의 경우 4, 7로 2자리, 4는 44, 47, 74, 77로 4자리) 
 * 		2.2 N이 절반 위치의 번째수가 작을 때에는 가장 앞자리가 4 클 때에는 7
 *	3. 먼저 입력받은 N이 어떤 영역에 위치할 수 있는지 찾음(2의 제곱수의 합만큼 계속 카운팅이 늘어나므로 등비수열의 합 공식을 활용해 탐색)
 *
 */
public class BaekJoon_2877 {
	static int N;
	static char[] comb;
	
	static int cal(int i) {
		return (int)(Math.pow(2, i) * (Math.pow(2, i) - 1) / Math.pow(2, i - 1));
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		int i = 1;
		while (cal(i) < N) {
			i++;
		}
		int left = cal(i - 1);
		int right = cal(i);
		int pointer = 0;
		
		comb = new char[i];
		while (pointer < i) {
			int mid = (left + right) / 2;
			if (N <= mid) {
				comb[pointer++] = '4';
				right = mid + 1;
			} else {
				comb[pointer++] = '7';
				left = mid;
			}
		}
		
		System.out.println(new String(comb));
		br.close();
	}

}
