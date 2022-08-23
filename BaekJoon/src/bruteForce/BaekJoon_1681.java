package bruteForce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 줄 세우기
public class BaekJoon_1681 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		String L = st.nextToken();
		int result = 0;
		while (N-- > 0) {
			result++;
			if (String.valueOf(result).contains(L)) N++;
		}
		System.out.println(result);
		br.close();
	}

}
