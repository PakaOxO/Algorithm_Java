package math;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_2745, 진법 변환
 * @author kevin-Arpe
 *
 * Sketch Idea
 * 	1. B의 0승부터 주어진 B진법 N의 문자 길이만큼 지수 차수를 증가시키면서 숫자	를 더해감
 * 	2. 모든 숫자의 합이 10진수로 변환된 수
 * 
 */
public class BaekJoon_2745 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String prev = st.nextToken();
		int B = Integer.parseInt(st.nextToken());
		
		int cLen = prev.length();
		int converted = 0;
		for (int i=1; i<=cLen; i++) {
			char c = prev.charAt(cLen - i);
			if (c >= 'A' && c <= 'Z') {
				converted += (Math.pow(B, i - 1) * (int)(c - 'A' + 10));
			} else {
				converted += Math.pow(B, i - 1) * (int)(c - '0');
			}
		}
		System.out.println(converted);
		br.close();
	}

}
