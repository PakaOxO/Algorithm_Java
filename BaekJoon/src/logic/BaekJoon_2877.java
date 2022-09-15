package logic;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_2877, 4와 7 
 * @author kevin-Arpe 
 * 
 * Sketch Idea
 * 	1. 4, 7 숫자를 탐색하면서 만들 수 있는 조합을 찾음 
 * 	2. 찾는 과정은 길이가 1짜리부터 하나씩 늘려가며 탐색 
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
		while (cal(i) <= N) {
			i++;
		}
		System.out.println(i);
		int cnt = cal(i);
	}

}
