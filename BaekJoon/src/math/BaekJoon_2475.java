package math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

// 검증 수
public class BaekJoon_2475 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BigInteger sum = new BigInteger("0");
		for (int i=0; i<5; i++) {
			BigInteger num = new BigInteger(st.nextToken());
			sum = sum.add(num.pow(2));
		}
		System.out.println(sum.remainder(new BigInteger("10")));
		br.close();
	}

}
