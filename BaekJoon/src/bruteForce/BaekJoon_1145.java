package bruteForce;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 적어도 대부분의 배수
public class BaekJoon_1145 {
	public static int gcd = 1;
	public static void getGCD(int a, int b) {
		if (b == 0) {
			gcd = a;
		} else {
			int remainder = (a > b) ? a % b : b % a;
			if (a > b) getGCD(b, remainder);
			else getGCD(a, remainder);
		}
	}
	
	public static int getLCM(int a, int b) {
		getGCD(a, b);
		return (a * b) / gcd;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = br.readLine().split(" ");
		int len = arr.length;
		int min = Integer.MAX_VALUE;
		for (int i=0; i<len; i++) {
			for (int j=i+1; j<len; j++) {
				for (int k=j+1; k<len; k++) {
					int lcm = getLCM(Integer.parseInt(arr[i]), Integer.parseInt(arr[j]));
					lcm = getLCM(lcm, Integer.parseInt(arr[k]));
					if (lcm < min) min = lcm;
				}
			}
		}
		System.out.println(min);
	}

}
