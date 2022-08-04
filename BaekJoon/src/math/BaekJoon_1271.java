package math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

// 엄청난 부자 2
public class BaekJoon_1271 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BigInteger M = new BigInteger(st.nextToken());
		BigInteger N = new BigInteger(st.nextToken());
		System.out.println(M.divide(N) + "\n" + M.remainder(N));
		br.close();
	}

}
