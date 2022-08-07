package level_03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 두문자어
public class SWEA_8741 {

	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i=1; i<=T; i++) {
			sb.append("#" + i + " ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			sb.append("" + st.nextToken().toUpperCase().charAt(0) + st.nextToken().toUpperCase().charAt(0) + st.nextToken().toUpperCase().charAt(0) + "\n");
		}
		System.out.println(sb.toString().trim());
		br.close();
	}

}
