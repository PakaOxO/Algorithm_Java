package recursive;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BaekJoon_1769 {
	
	static String sum(String num) {
		long sum = 0;
		
		for (int i=0; i<num.length(); i++) {
			sum += Character.getNumericValue(num.charAt(i));
		}
		
		return Long.toString(sum);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String N = br.readLine();
		int cnt = 0;
		while (N.length() > 1) {
			N = sum(N);
			cnt++;
		}
		String answer = "NO";
		if (N.equals("3") || N.equals("6") || N.equals("9")) answer = "YES";
			
		System.out.println(cnt);
		System.out.println(answer);
		br.close();
	}

}
