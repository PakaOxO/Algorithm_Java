package math;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_25193, 곰곰이의 식단관리
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 
 *
 */
public class BaekJoon_25193 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String input = br.readLine();
		
		int cCnt = 0;
		int oCnt = 0;
		for (int i=0; i<N; i++) {
			char c = input.charAt(i);
			if (c == 'C') cCnt++;
			else oCnt++;
		}
		
		if (cCnt <= 1 || oCnt == 0) System.out.println(cCnt);
		else {
			int answer = cCnt / (oCnt + 1);
			if (cCnt % (oCnt + 1) > 0) answer++;
			System.out.println(answer);
		}
	}

}
