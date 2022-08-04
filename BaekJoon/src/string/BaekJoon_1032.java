package string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 명령 프롬프트
public class BaekJoon_1032 {
	public static int[] isDiff;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		String str = br.readLine();
		int len = str.length();
		isDiff = new int[len];
		for (int i=1; i<T; i++) {
			String nextStr = br.readLine();
			for (int j=0; j<len; j++) {
				if (isDiff[j] != 1 && nextStr.charAt(j) != str.charAt(j)) isDiff[j]++;
			}
		}
		
		for (int i=0; i<len; i++) {
			if (isDiff[i] == 0) sb.append(str.charAt(i));
			else sb.append("?");
		}
		System.out.println(sb);
	}

}
