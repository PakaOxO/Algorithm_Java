package string;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_11655, ROT13
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 아스키 코드를 사용하여 아스키 문자에서 13씩 밀어준다.
 * 	2. 문자 범위 이상으로 밀린 숫자는 보정 필요.
 * 	3. 변환된 char Array를 String 생성자에 넣어 문자열로 변환
 *
 */
public class BaekJoon_11655 {
	static char[] cArr;
	
	static void rot13() {
		for (int i=0; i<cArr.length; i++) {
			char c = cArr[i];
			if ((int)c < 65) continue;
			if ((int)c >= 97) {
				cArr[i] = (int)(cArr[i] + 13) > 122 ? (char)(cArr[i] - 13) : (char)(cArr[i] + 13);
			} else {
				cArr[i] = (int)(cArr[i] + 13) > 90 ? (char)(cArr[i] - 13) : (char)(cArr[i] + 13);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		cArr = br.readLine().toCharArray();
		rot13();
		System.out.println(new String(cArr));
		br.close();
	}

}
