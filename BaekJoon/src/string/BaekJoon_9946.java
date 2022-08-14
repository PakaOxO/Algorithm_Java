package string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 단어 퍼즐
public class BaekJoon_9946 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int tNo = 0;
		while (true) {
			tNo++;
			String str1 = br.readLine();
			String str2 = br.readLine();
			/* 입력 받은 두 단어가 END이면 반복문 종료 */
			if (str1.equals("END") && str2.equals("END")) break;
			/* 입력 단어의 문자 개수를 배열에 저장 */
			char[] cCnt = new char[26];
			for (int i=0; i<str1.length(); i++) {
				cCnt[str1.charAt(i) - 'a']++;
			}
			/* 비교 대상 문자열을 돌면서 cnt 배열에서 동일한 단어가 있으면 -1, 없다면(0) break */ 
			boolean isSame= true;
			for (int i=0; i<str2.length(); i++) {
				int idx = str2.charAt(i) - 'a';
				if (cCnt[idx] > 0) cCnt[idx]--;
				else {
					isSame = false;
					break;
				}
			}
			if (isSame) sb.append("Case " + tNo + ": same\n");
			else sb.append("Case " + tNo + ": different\n");
		}
		System.out.println(sb.toString().trim());
		br.close();
	}

}
