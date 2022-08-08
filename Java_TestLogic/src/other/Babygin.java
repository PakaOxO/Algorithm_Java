package other;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Babygin {
	static boolean isRun(int a, int b, int c) {
		if (a == b && b == c) return true;
		return false;
	}
	
	static boolean isTriplet(int a, int b, int c) {
		if (a + 1 == b && b + 1 == c) return true;
		return false;
	}
	
	static boolean isBabyGin(int[] arr) {
		if ((isRun(arr[0], arr[1], arr[2]) || isTriplet(arr[0], arr[1], arr[2])) && (isRun(arr[3], arr[4], arr[5]) || isTriplet(arr[3], arr[4], arr[5]))) return true;
		
		return false;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] cards = new int[6];
		int idx = 0;
		while (st.hasMoreTokens()) {
			try {
				int num = Integer.parseInt(st.nextToken());
				cards[idx++] = num;
			} catch (Exception e) {
				e.getStackTrace();
			}
		}		
		Arrays.sort(cards);
		System.out.println(isBabyGin(cards));
	}

}
