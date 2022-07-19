package level_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 두 개의 숫자열
public class SWEA_1959 {
	public static int getCrossSum(String[] Aj, String[] Bj) {
		int max = Integer.MIN_VALUE;
		int idxGap = 0;
		while (idxGap <= Aj.length - Bj.length) {
			int sum = 0;
			for (int j=0; j<Bj.length; j++) {
				sum += (Integer.parseInt(Aj[j + idxGap]) * Integer.parseInt(Bj[j]));
			}
			if (sum > max) max = sum;
			idxGap++;
		}
		
		return max;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCnt = Integer.parseInt(br.readLine());
		for (int i=0; i<testCnt; i++) {
			String[] lengths = br.readLine().split(" ");
			int lenA = Integer.parseInt(lengths[0]);
			int lenB = Integer.parseInt(lengths[1]);
			
			String[] arr1 = br.readLine().split(" ");
			String[] arr2 = br.readLine().split(" ");
			
			int max;
			if (lenA > lenB) {
				max = getCrossSum(arr1, arr2);
			} else {
				max = getCrossSum(arr2, arr1);
			}
			System.out.printf("#%d %d\n", i + 1, max);
		}
	}

}
