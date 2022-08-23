package math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 포켓몬 GO
public class BaekJoon_13717 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String m = "";
		int eTotal = 0;
		int eMax = 0;
		for (int i=0; i<N; i++) {
			String pm = br.readLine();
			StringTokenizer st = new StringTokenizer(br.readLine());
			int K = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
			
			int eCnt = 0;
			while (K <= M) {
				M = M - K + 2;
				eCnt++;
			}
			
			eTotal += eCnt;
			if (eCnt > eMax) {
				m = pm;
				eMax = eCnt;
			}
		}
		System.out.println(eTotal);
		System.out.println(m);
		br.close();
	}

}
