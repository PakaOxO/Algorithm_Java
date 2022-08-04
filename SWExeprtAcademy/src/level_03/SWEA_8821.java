package level_03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 적고 지우기
public class SWEA_8821 {
	public static int[] hasNum;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i=1; i<=T; i++) {
			String input = br.readLine();
			hasNum = new int[10];
			for (int j=0; j<input.length(); j++) {
				int num = Character.getNumericValue(input.charAt(j));
				hasNum[num] = ++hasNum[num] % 2;
			}
			
			int cnt = 0;
			for (int j=0; j<10; j++) {
				// System.out.println(hasNum[j]);
				if (hasNum[j] == 1) cnt++;
			}
			sb.append("#" + i + " " + cnt + "\n");
		}
		System.out.println(sb.toString().trim());
		br.close();
	}

}
