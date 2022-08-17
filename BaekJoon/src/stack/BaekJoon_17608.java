package stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 막대기
public class BaekJoon_17608 {
	static int[] height;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		height = new int[N];
		for (int i=0; i<N; i++) {
			height[i] = Integer.parseInt(br.readLine());
		}
		int cnt = 1;
		int max = height[N-1];
		for (int i=N-2; i>=0; i--) {
			if (height[i] > max) {
				cnt++;
				max = height[i];
			}
		}
		System.out.println(cnt);
		br.close();
	}

}
