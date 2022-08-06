package string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 2진수 8진수
public class BaekJoon_1373 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String binary = br.readLine();
		int binaryLen = binary.length();
		int octalLen = ( binaryLen % 3 == 0 ) ? binaryLen / 3 : binaryLen / 3 + 1;
		int[] octalArr = new int[octalLen];
		int idx = octalLen - 1;
		for (int i=binaryLen-1; i>=0; i--) {
			int num = binary.charAt(i) - '0';
			if ((binaryLen-1-i) % 3 == 0) {
				octalArr[idx] += num * 1;
			} else if ((binaryLen-1-i) % 3 == 1) {
				octalArr[idx] += num * 2;
			} else {
				octalArr[idx--] += num * 4;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<octalLen; i++) {
			sb.append(octalArr[i]);
		}
		System.out.println(sb);
		br.close();
	}

}
