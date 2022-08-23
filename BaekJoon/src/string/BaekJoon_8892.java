package string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 팰린드롬
public class BaekJoon_8892 {
	static String[] words;
	
	static boolean isPalindrome(String str) {
		int len = str.length();
		for (int i=0; i<len; i++) {
			if (i == len - i - 1) break;
			if (str.charAt(i) == str.charAt(len - i - 1)) continue;
			return false;
		}
		return true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc=0; tc<T; tc++) {
			int N = Integer.parseInt(br.readLine());
			words = new String[N];
			for (int i=0; i<N; i++) {
				words[i] = br.readLine();
			}
			
			boolean flag = true;
			for (int i=0; i<N; i++) {
				if (!flag) break;
				for (int j=i+1; j<N; j++) {
					StringBuilder sb1 = new StringBuilder();
					sb1.append(words[i]).append(words[j]);
					if (isPalindrome(sb1.toString())) {
						answer.append(sb1).append("\n");
						flag = false;
						break;
					}
					StringBuilder sb2 = new StringBuilder();
					sb2.append(words[j]).append(words[i]);
					if (isPalindrome(sb2.toString())) {
						answer.append(sb2).append("\n");
						flag = false;
						break;
					}
				}
			}
			if (flag) answer.append("0\n");
		}
		System.out.print(answer);
		br.close();
	}

}
