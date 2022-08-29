package bruteForce;

import java.io.*;
import java.util.*;
import java.math.BigInteger;

// 암호 키 (복습)
public class BaekJoon_1816_2 {
	static boolean[] isNotPrime = new boolean[1000001];
	static List<Integer> listPrimeNo;
	
	static boolean isValid(String num) {
		BigInteger bi = new BigInteger(num);
		for (int i=0; i<listPrimeNo.size(); i++) {
			if (bi.remainder(BigInteger.valueOf(listPrimeNo.get(i))).equals(BigInteger.valueOf(0))) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		listPrimeNo = new ArrayList<>();
		for (int i=2; i*i<1000001; i++) {
			if (isNotPrime[i]) continue;
			
			for (int j=i*i; j<1000001; j+=i) {
				isNotPrime[j] = true;
			}
		}
		
		for (int i=2; i<1000001; i++) {
			if (!isNotPrime[i]) listPrimeNo.add(i);
		}
		
		for (int i=0; i<N; i++) {
			if (isValid(br.readLine())) sb.append("YES\n");
			else sb.append("NO\n");
		}
		System.out.print(sb);
		br.close();
	}

}
