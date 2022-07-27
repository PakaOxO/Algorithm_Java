package level_03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// Calkin-Wilf tree
public class SWEA_11688 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i=1; i<=T; i++) {
			String input = br.readLine();
			int a = 1;
			int b = 1;
			for (int j=0; j<input.length(); j++) {
				char c = input.charAt(j);
				if (c == 'L') {
					b = a + b;
				} else {
					a = a + b;
				}
			}
			System.out.printf("#%d %d %d\n", i, a,  b);
		}
		br.close();
	}
}
