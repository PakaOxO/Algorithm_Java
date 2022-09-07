package bruteForce;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_19532, 수학은 비대면강의입니다
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 연립방정식의 해를 묻는 문제이므로 연립방정식의 해 x를 구한뒤 나머지 y의 값을 구한다.
 *
 */
public class BaekJoon_19532 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		int f = Integer.parseInt(st.nextToken());
		
		int x = (b * f - (c * e)) / (b * d - (a * e));
		int y = (b != 0) ? (c - (a * x)) / b : (f - (d * x)) / e;
		
		System.out.println(x + " " + y);
		br.close();
	}

}
