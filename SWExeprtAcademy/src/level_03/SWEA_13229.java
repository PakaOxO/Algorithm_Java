package level_03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 일요일
public class SWEA_13229 {
	public static String[] day = { "SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT" };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		int index = 0;
		for (int i=1; i<=T; i++) {
			String input = br.readLine();
			for (int j=0; j<7; j++) {
				if (day[j].equals(input)) {
					index = j;
					break;
				}
			}
			sb.append("#" + i + " " + ((7 - index) % 8) + "\n");
		}
		System.out.println(sb.toString().trim());
		br.close();
	}

}
