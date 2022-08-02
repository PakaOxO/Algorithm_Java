package array;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 숫자의 개수
public class BaekJoon_2577 {
	public static int[] cnt = new int[10];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());
		
		char[] multiple = Integer.toString(A * B * C).toCharArray();
		for (char num : multiple) {
			cnt[Character.getNumericValue(num)]++;
		}
		StringBuilder sb = new StringBuilder();
		for (int i : cnt) {
			sb.append(i + "\n");
		}
		System.out.println(sb.toString().trim());
	}

}
