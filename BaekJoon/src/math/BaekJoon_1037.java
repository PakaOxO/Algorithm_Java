package math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 약수
public class BaekJoon_1037 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int i=0; i<T; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (num > max) max = num;
			if (num < min) min = num;
		}
		System.out.println(min * max);
	}

}
