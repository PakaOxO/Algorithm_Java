package array;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 최댓값
public class BaekJoon_2562 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int idx = 0;
		int max = Integer.MIN_VALUE;
		for (int i=1; i<=9; i++) {
			int num = Integer.parseInt(br.readLine());
			if (num > max) {
				max = num;
				idx = i;
			}
		}
		System.out.println(max + "\n" + idx);
		br.close();
	}

}
