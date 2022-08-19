package level_03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 성공적인 공연 기획
public class SWEA_4789 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc=1; tc<=T; tc++) {
			String input = br.readLine();
			int cnt = 0;
			int answer = 0;
			for (int i=0; i<input.length(); i++) {
				int people = Character.getNumericValue(input.charAt(i));
				if (cnt < i) {
					answer += (i - cnt);
					cnt += people + (i - cnt);
					continue;
				}
				cnt += people;
			}
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		System.out.print(sb);
		br.close();
	}

}
