package string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// Æç¸°µå·Ò ¼ö
public class BaekJoon_1259 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = br.readLine();
		while (!str.equals("0")) {
			int len = str.length();
			boolean isPalindrome = true;
			for (int i=0; i<=len/2; i++) {
				if (str.charAt(i) != str.charAt(len-i-1)) isPalindrome = false;
			}
			if (isPalindrome) sb.append("yes\n");
			else sb.append("no\n");
			str = br.readLine();
		}
		System.out.println(sb.toString().trim());
		br.close();
	}

}
