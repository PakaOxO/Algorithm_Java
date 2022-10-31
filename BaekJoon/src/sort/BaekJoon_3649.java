package sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * BaekJoon_3649, 로봇 프로젝트
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 
 *
 */
public class BaekJoon_3649 {
	static int x, n, min, max;
	static int[] l;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str;
		while (true) {
			str = br.readLine();
			if (str == null || str.equals("")) break;
			
			x = Integer.parseInt(str);
			n = Integer.parseInt(br.readLine());
			
			l = new int[100000001];
			min = Integer.MAX_VALUE;
			max = 100000000;
			for (int i=0; i<n; i++) {
				int len = Integer.parseInt(br.readLine());
				l[len]++;
				if (len < min) min = len;
			}
			String answer = "danger\n";
			if (n >= 2) {
				for (int i=min; i<=max; i++) {
					int res = x * 10000000 - i;
					if (res < i) break;
					if (res > max) continue;
					if (l[i] > 0 && l[res] > 0) {
						if (i == res && l[i] < 2) break;
						answer = String.format("yes %d %d\n", i, res);
						break;
					}
				}
			}
			sb.append(answer);
		}
		System.out.print(sb);
	}
}
