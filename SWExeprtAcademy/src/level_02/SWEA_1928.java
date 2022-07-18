package level_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// base64 decoder
public class SWEA_1928 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCnt = Integer.parseInt(br.readLine());
		// 문제에서 제공한 decoder
		String[] decoder = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"
							, "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"
							, "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "+", "/" };
		for (int i=0; i<testCnt; i++) {
			String[] strArr = br.readLine().split("");
			String byteString = "";
			for (String letter:strArr) {
				// 각 문자를 decoder로 숫자로 변환
				int num = Arrays.asList(decoder).indexOf(letter);
				// 변환된 숫자를 2진수로 변환
				String binary = Integer.toBinaryString(num);
				// 변환된 2진수를 8비트까지 0으로 채움
				while (binary.length() < 6) {
					binary = "0" + binary;
				}
				// 모든 2진수를 이어 붙임
				byteString += binary;
			}
			String result = "";
			int idx = 0;
			while (idx < byteString.length()) {
				// 8비트씩 자른 뒤, 10진수로 변환하고, 다시 아스키코드로 문자로 변환
				String sliced = byteString.substring(idx, idx+8);
				result += (char)Integer.parseInt(sliced, 2);
				idx += 8;
			}
			System.out.printf("#%d %s\n", i + 1, result);
		}
	}

}
