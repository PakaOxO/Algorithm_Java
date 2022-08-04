package level_03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 홀수일까 짝수일까
public class SWEA_5549 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i=1; i<=T; i++) {
			String input = br.readLine();
			String result = (int)input.charAt(input.length() - 1) % 2 == 0 ? "Even" : "Odd";
			sb.append("#" + i + " " + result + "\n");
		}
		System.out.println(sb.toString().trim());
		br.close();
	}

}
