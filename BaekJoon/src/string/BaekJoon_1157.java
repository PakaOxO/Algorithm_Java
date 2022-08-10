package string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 단어 공부
public class BaekJoon_1157 {
	
	static int[] cnt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine().toUpperCase();
		cnt = new int[26];
		for (int i=0; i<input.length(); i++) {
			cnt[input.charAt(i) - 'A']++;
		}
		int cMax = 0;
		for (int i=0; i<cnt.length; i++) {
			if (cnt[i] >= cMax) cMax = cnt[i];
		}
		
		char answer = ' ';
		boolean chk = true;
		for (int i=0; i<cnt.length; i++) {
			if (cnt[i] == cMax) {
				if (chk) {
					answer = (char)(i + (int)'A');
					chk = false;
				}
				else {
					answer = '?';
					break;
				}
			}
		}
		System.out.println(answer);
	}

}
