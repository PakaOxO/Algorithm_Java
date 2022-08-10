package search;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

// 제곱근
public class BaekJoon_13706 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BigInteger input = new BigInteger(br.readLine());
		System.out.println(input.sqrt());
		br.close();
	}

}
