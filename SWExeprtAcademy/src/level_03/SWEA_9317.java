package level_03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 석찬이의 받아쓰기
public class SWEA_9317 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i=1; i<=T; i++) {
			int N = Integer.parseInt(br.readLine());
			String str1 = br.readLine();
			String str2 = br.readLine();
			int result = 0;
			for (int j=0; j<N; j++) {
				if ((int)str1.charAt(j) == (int)str2.charAt(j)) result++;
			}
			System.out.printf("#%d %d\n", i, result);
		}
		br.close();
	}

}
