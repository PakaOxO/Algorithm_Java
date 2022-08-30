package math;

import java.io.*;
import java.util.*;

// 소수인 팰린드롬
public class BaekJoon_1990 {
	static boolean[] isNotPrime;
	
	static boolean isPalindrome(int i) {
		String str = String.valueOf(i);
		int left = 0;
		int right = str.length() - 1;
		while (left < right) {
			if (str.charAt(left) != str.charAt(right)) return false;
			left++;
			right--;
		}
		return true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		isNotPrime = new boolean[B+1];
		for (int i=2; i*i<=B; i++) {
			if (isNotPrime[i]) continue;
			for (int j=i*i; j<=B; j+=i) {
				isNotPrime[j] = true;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i=A; i<=B; i++) {
			if (isNotPrime[i]) continue;
			if (isPalindrome(i)) sb.append(i).append("\n");
		}
		sb.append(-1).append("\n");
		System.out.print(sb);
		br.close();
	}

}
