package loop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// A + B - 3
public class BaekJoon_10950 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i=1; i<=T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			System.out.println(a + b);
		}
		br.close();
	}

}
