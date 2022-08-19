package level_03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 영준이의 카드 카운팅
public class SWEA_4047 {
	static int[][] cards;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc=1; tc<=T; tc++) {
			int[] cntMax = { 13, 13, 13, 13 };
			String str = br.readLine();
			cards = new int[4][13];
			sb.append("#").append(tc).append(" ");
			boolean isError = false;
			for (int i=0; i<str.length(); i+=3) {
				char type = str.charAt(i);
				int num = Integer.parseInt(str.charAt(i+1) + "" + str.charAt(i + 2)) - 1;
				if (type == 'S') {
					if (cards[0][num] > 0) {
						sb.append("ERROR\n");
						isError = true;
						break;
					}
					cards[0][num]++;
					cntMax[0]--;
				} else if (type == 'D') {
					if (cards[1][num] > 0) {
						sb.append("ERROR\n");
						isError = true;
						break;
					}
					cards[1][num]++;
					cntMax[1]--;
				} else if (type == 'H') {
					if (cards[2][num] > 0) {
						sb.append("ERROR\n");
						isError = true;
						break;
					}
					cards[2][num]++;
					cntMax[2]--;
				} else if (type == 'C') {
					if (cards[3][num] > 0) {
						sb.append("ERROR\n");
						isError = true;
						break;
					}
					cards[3][num]++;
					cntMax[3]--;
				}
			}
			if (!isError) {
				for (int i=0; i<4; i++) {
					sb.append(cntMax[i]);
					if (i < 3) sb.append(" ");
				}
				sb.append("\n");
			}
		}
		System.out.print(sb);
		br.close();
	}
}
