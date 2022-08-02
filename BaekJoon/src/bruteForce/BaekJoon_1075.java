package bruteForce;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 나누기
public class BaekJoon_1075 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		int N = Integer.parseInt(br.readLine());
		int F = Integer.parseInt(br.readLine());
		
		int min = (N / 100) * 100;
		int result = (min % F == 0) ? min : (min / F + 1) * F;
		System.out.printf("%02d", result % 100);
	}

}
