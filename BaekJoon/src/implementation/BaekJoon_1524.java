package implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 세준 세비
public class BaekJoon_1524 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i=1; i<=T; i++) {
			br.readLine();
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			
			int sMax = Integer.MIN_VALUE;
			int bMax = Integer.MIN_VALUE;
			
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				sMax = Math.max(sMax, Integer.parseInt(st.nextToken()));
			}
			
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<M; j++) {
				bMax = Math.max(bMax, Integer.parseInt(st.nextToken()));
			}
			
			if (N == 0 && M == 0) {
				System.out.println("C");
				continue;
			}
			
			
			if ( sMax >= bMax ) System.out.println("S");
			else System.out.println("B");
		}
		br.close();
	}

}
