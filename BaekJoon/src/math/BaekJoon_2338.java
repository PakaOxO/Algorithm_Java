package math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

// 긴자리 계산
public class BaekJoon_2338 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BigInteger A = new BigInteger(br.readLine());
		BigInteger B = new BigInteger(br.readLine());
		System.out.println(A.add(B) + "\n" + A.subtract(B) + "\n" + A.multiply(B));
		br.close();
	}

}
