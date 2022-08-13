package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BaekJoon_2810 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String seats = br.readLine();
		int cnt = 1;
		for (int i=0; i<N; i++) {
			if (seats.charAt(i) == 'S') cnt++;
			else {
				cnt++;
				i++;
			}
		}
		if (cnt >= N) System.out.println(N);
		else System.out.println(cnt);
		br.close();
	}

}
