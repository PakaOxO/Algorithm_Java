package string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 크로아티아 알파벳 
public class BaekJoon_2941 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int N = str.length();
		int cnt = 0;
		for (int i=0; i<N; i++) {
			char c = str.charAt(i);
			if (c == 'd' && i < N - 1) {
				if (i < N - 2 && str.charAt(i+1) == 'z' && str.charAt(i+2) == '=') {
					i += 2;
				} else if (str.charAt(i+1) == '-') {
					i++;
				}
			} else if (c == 'z' && i < N - 1) {
				if (str.charAt(i+1) == '=') {
					i++;
				}
			} else if (c == 'c' && i < N - 1) {
				if (str.charAt(i+1) == '=' || str.charAt(i+1) == '-') {
					i++;
				}
			} else if (c == 's' && i < N - 1) {
				if (str.charAt(i+1) == '=') {
					i++;
				}
			} else if (c == 'l' && i < N - 1) {
				if (str.charAt(i+1) == 'j') {
					i++;
				}
			} else if (c == 'n' && i < N - 1) {
				if (str.charAt(i+1) == 'j') {
					i++;
				}
			}
			cnt++;
		}
		System.out.println(cnt);
		br.close();
	}

}
