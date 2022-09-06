package math;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_10824, 네 수
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 붙일 두 수를 문자열화 하여 붙인 뒤 다시 숫자 타입으로 바꾸어 연산 실행
 *
 */
public class BaekJoon_10824 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		System.out.println(Long.valueOf(st.nextToken() + st.nextToken()) + Long.valueOf(st.nextToken() + st.nextToken()));
		br.close();
	}

}
