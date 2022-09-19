package math;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_11576, Base Conversion
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 먼저 A진수로 작성된 수를 10진수로 변환
 * 	2. 10진수로 변환한 수를 B진수로 변환하여 리턴
 *
 */
public class BaekJoon_11576 {
	static void conversion(int B, int num) {
		List<Integer> list = new ArrayList<>();
		while (num > 0) {
			list.add(num % B);
			num /= B;
		}
		StringBuilder sb = new StringBuilder();
		for (int i=list.size()-1; i>=0; i--) {
			sb.append(list.get(i)).append(" ");
		}
		System.out.println(sb.toString().trim());
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int decimal = 0;
		int multi = 1;
		for (int i=N-1; i>=0; i--) {
			decimal += arr[i] * multi;
			multi *= A;
		}
		
		conversion(B, decimal);
		br.close();
	}

}
