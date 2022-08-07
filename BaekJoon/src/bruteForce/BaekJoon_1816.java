package bruteForce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

// 암호 키
public class BaekJoon_1816 {
	private static boolean[] isNotPrimeNo = new boolean[1000001];
	private static List<Integer> listPrimeNo = new ArrayList<>();
	
	private static boolean isValidKey(BigInteger num) {
		for (int i=0; i<listPrimeNo.size(); i++) {
			if (num.remainder(BigInteger.valueOf(listPrimeNo.get(i))).equals(BigInteger.valueOf(0))) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) throws Exception {
		for (int i=2; i*i<=1000000; i++) {
			for (int j=i*i; j<=1000000; j+=i) {
				isNotPrimeNo[j] = true;
			}
		}
		
		for (int i=2; i<=1000000; i++) {
			if (!isNotPrimeNo[i]) listPrimeNo.add(i);
		}
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<T; i++) {
			BigInteger input = new BigInteger(br.readLine());
			if (isValidKey(input)) {
				sb.append("YES\n");
			} else {
				sb.append("NO\n");
			}
		}
		System.out.println(sb.toString().trim());
		br.close();
	}

}
