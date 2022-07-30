package math;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 집 주소
public class BaekJoon_1284 {
	public static int[] width = { 4, 2, 3, 3, 3, 3, 3, 3, 3, 3 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String N;
		while (!(N = br.readLine()).equals("0")) {
			int total = 1;
			for (int i=0; i < N.length(); i++) {
				total += (width[Character.getNumericValue(N.charAt(i))] + 1);
			}
			sb.append(total + "\n");
		}
		System.out.println(sb.toString().trim());
		br.close();
	}

}
