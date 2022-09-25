package bitmasking;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_11723, 집합
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 비트 연산자를 연습할 수 있는 좋은 문제
 * 	2. <<, >>, &, |, ~, ^ 등의 비트 연산의 결과를 이해하는데 도움이 되는 문제였습니다.
 *
 */
public class BaekJoon_11723 {
	static StringTokenizer st;
	static int comb;
	static StringBuilder sb;
	
	
	static void operation(String type) {
		int num = -1;
		switch (type) {
			case "add":
				num = Integer.parseInt(st.nextToken());
				if ((comb & (1 << num)) == 0) {
					comb = comb + (1 << num);
				}
				break;
				
			case "check":
				num = Integer.parseInt(st.nextToken());
				if ((comb & (1 << num)) > 0) sb.append("1\n");
				else sb.append("0\n");
				break;
				
			case "remove":
				num = Integer.parseInt(st.nextToken());
				if ((comb & (1 << num)) > 0) {
					comb = comb - (1 << num);
				}
				break;
				
			case "toggle":
				num = Integer.parseInt(st.nextToken());
				if ((comb & (1 << num)) > 0) {
					comb = comb - (1 << num);
				} else comb = comb + (1 << num);
				break;
				
			case "all":
				comb = 0;
				int idx = 1;
				while (idx <= 20) {
					comb += (1 << idx++);
				}
				break;
				
			case "empty":
				comb = 0;
				break;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		sb = new StringBuilder();
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			String type = st.nextToken();
			operation(type);
		}
		br.close();
		
		System.out.println(sb);
	}

}
