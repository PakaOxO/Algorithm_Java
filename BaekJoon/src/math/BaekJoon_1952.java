package math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


// ¥ﬁ∆ÿ¿Ã 2
public class BaekJoon_1952 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int cnt = 0;
		int cycle = 0;
		while (true) {
			if  (cycle % 2 == 0) {
				if (N == 1) break;
				N--;
				cnt++;
			} else {
				if (M == 1) break;
				M--;
				cnt++;
			}
			cycle++;
		}
		System.out.println(cnt);
		br.close();
	}

}
