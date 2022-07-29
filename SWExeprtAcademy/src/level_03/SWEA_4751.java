package level_03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 다솔이의 다이아몬드 장식
public class SWEA_4751 {
	public static String[] deco = { ".#..", "#." };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i=1; i<=T; i++) {
			StringBuilder sb = new StringBuilder();
			String str = br.readLine();
			for (int j=0; j<5; j++) {
				if (j == 2) {
					int idx = 0;
					for (int k=0; k<str.length()*4+1; k++) {
						if (k == (idx * 4 + 2)) {
							sb.append(str.charAt(idx));
							idx++;
						} else {
							if (k % 2 == 0) sb.append("#");
							else sb.append(".");
						}
					}
					sb.append("\n");
					continue;
				} else {
					sb.append(".");
					for (int k=0; k<str.length()*(j%2+1); k++) {
						sb.append(deco[j%2]);
					}
				}
				sb.append("\n");
			}
			System.out.println(sb.toString().trim());
		}
		br.close();
	}

}
