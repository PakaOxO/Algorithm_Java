package stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 화학식량
public class BaekJoon_2257 {
	static int[] cnt;
	static int idx;
	
	static String input;
	static char prev;
	
	static int[] checkExpr(int hCnt, int cCnt, int oCnt) {
		while (idx < input.length()) {
			char c = input.charAt(idx);
			if (c == '(') {
				idx++;
				int[] innerCnt = checkExpr(0, 0, 0);
				hCnt += innerCnt[0];
				cCnt += innerCnt[1];
				oCnt += innerCnt[2];
				continue;
			}
			if (c == ')') {
				if (idx + 1 < input.length() && (input.charAt(idx + 1) >= '1' && input.charAt(idx + 1) <= '9')) {
					int m = Character.getNumericValue(input.charAt(++idx));
					hCnt *= m;
					cCnt *= m;
					oCnt *= m;
				}
				idx++;
				int[] returnCnt = { hCnt, cCnt, oCnt };
				return returnCnt;
			}
			if (c == 'H') {
				if (idx + 1 < input.length() && (input.charAt(idx + 1) >= '1' && input.charAt(idx + 1) <= '9')) {
					int m = Character.getNumericValue(input.charAt(++idx));
					hCnt += m;
					continue;
				}
				hCnt++;
			}
			else if (c == 'C') {
				if (idx + 1 < input.length() && (input.charAt(idx + 1) >= '1' && input.charAt(idx + 1) <= '9')) {
					int m = Character.getNumericValue(input.charAt(++idx));
					cCnt += m;
					continue;
				}
				cCnt++;
			}
			else if (c == 'O') {
				if (idx + 1 < input.length() && (input.charAt(idx + 1) >= '1' && input.charAt(idx + 1) <= '9')) {
					int m = Character.getNumericValue(input.charAt(++idx));
					oCnt += m;
					continue;
				}
				oCnt++;
			}
			idx++;
		}
		
		int[] returnCnt = { hCnt, cCnt, oCnt };
		return returnCnt;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		input = br.readLine();
		
		cnt = new int[3];
		idx = 0;
		cnt = checkExpr(0, 0, 0);
		
		System.out.println(cnt[0] + (cnt[1] * 12) + (cnt[2] * 16));
		br.close();
	}

}
