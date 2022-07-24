package level_03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_12368 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i=0; i<T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int sum = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
			System.out.printf("#%d %d\n", i + 1, sum % 24);
		}
		br.close();
	}

}
