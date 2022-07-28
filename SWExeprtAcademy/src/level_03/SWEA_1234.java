package level_03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 비밀번호
public class SWEA_1234 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		for (int i=1; i<=10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			StringBuilder sb = new StringBuilder(st.nextToken());
			for (int j=N-1; j>0; j--) {
				if (sb.charAt(j) == sb.charAt(j-1)) {
					int len = sb.length();
					sb.deleteCharAt(j);
					sb.deleteCharAt(j-1);
					if (j == len-1) j--;
				}
			}
			result.append("#" + i + " " + sb + "\n");
		}
		System.out.println(result.toString().trim());
		br.close();
	}

}
