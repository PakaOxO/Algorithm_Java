package level_03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 모음이 보이지 않는 사람
public class SWEA_4406 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i=0; i<T; i++) {
			String input = br.readLine();
//			String inverted = input.replaceAll("[aeiou]", "");
//			System.out.printf("#%d %s\n", i + 1, inverted);
			
			StringBuilder sb = new StringBuilder();
			for (int j=0; j<input.length(); j++) {
				char letter = input.charAt(j);
				if (letter != 'a' && letter != 'e' && letter != 'i' && letter != 'o' && letter != 'u') {
					sb.append(letter);
				}
			}
			System.out.printf("#%d %s\n", i + 1, sb);
			
		}
		br.close();
	}

}
