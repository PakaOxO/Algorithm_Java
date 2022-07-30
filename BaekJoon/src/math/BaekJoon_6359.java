package math;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 만취한 상법
public class BaekJoon_6359 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i=1; i<=T; i++) {
			int N = Integer.parseInt(br.readLine());
			int cnt = 0;
			for (int x=1, dx = 3; x <= N; x += dx, dx+= 2) {
				cnt++;
			}
			System.out.println(cnt);
		}
		br.close();
	}

}
