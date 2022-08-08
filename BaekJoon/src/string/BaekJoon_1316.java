package string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 그룹 단어 체커
public class BaekJoon_1316 {
	static int[] cnt;
	
	static boolean wordChecker(String word) {
		if (word.length() <= 2) return true;
		int prev = (int)word.charAt(0) - 97;
		for (int i=0; i<word.length(); i++) {
			int letter = (int)word.charAt(i) - 97;
			if (cnt[letter] == 0) {
				cnt[letter]++;
				prev = letter;
			} else {
				if (prev != letter) return false;
			}
		}
		return true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int result = 0;
		int N = Integer.parseInt(br.readLine());
		for (int i=0; i<N; i++) {
			cnt = new int[26];
			String str = br.readLine();
			if (wordChecker(str)) {
				result++;
			}
		}
		System.out.println(result);
		br.close();
	}

}
