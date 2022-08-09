package math;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// ¹Ý¿Ã¸²
public class BaekJoon_2033 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		double input = Integer.parseInt(br.readLine());
		
		double divider = 10;
		while (true) {
			if (divider > input) break;
			double share = Math.floor(input / divider);
			double remainder = input % divider;
			if (remainder >= 5 * (divider / 10)) {
				input = (share + 1) * divider;
			} else {
				input = share * divider;
			}
			
			divider *= 10;
		}
		System.out.printf("%.0f", input);
		
		br.close();
	}
}
