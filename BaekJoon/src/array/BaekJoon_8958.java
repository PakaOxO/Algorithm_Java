package array;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// OX 퀴즈
public class BaekJoon_8958 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int i=1; i<=T; i++) {
			String line = br.readLine();
			int score = 0;
			int result = 0;
			for (int j=0; j<line.length(); j++) {
				if (line.charAt(j) == 'O') {
					result += ++score;
				} else {
					score = 0;
				}
			}
			sb.append(result + "\n");
		}
		System.out.println(sb.toString().trim());
		br.close();
	}

}
