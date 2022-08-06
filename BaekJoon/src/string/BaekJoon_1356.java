package string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 유진수
public class BaekJoon_1356 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String answer = "NO";
		for (int i=1; i<str.length(); i++) {
			String f = str.substring(0, i);
			String b = str.substring(i);
			int multipleF = 1;
			for (int j=0; j<f.length(); j++) {
				multipleF *= Character.getNumericValue(f.charAt(j));
			}
			int multipleB = 1;
			for (int j=0; j<b.length(); j++) {
				multipleB *= Character.getNumericValue(b.charAt(j));
			}
			if (multipleF == multipleB) {
				answer = "YES";
				break;
			}
		}
		System.out.println(answer);
	}

}
