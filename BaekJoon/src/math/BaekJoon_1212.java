package math;

import java.io.*;

/**
 * BaekJoon_1212, 8진수 2진수
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 8진수 한자리는 2진수에서 3자리씩 차지(7(8) -> 111(2))
 * 	2. 2진수의 자리수를 만든 뒤 각 자리 수를 채워가도록...
 *
 */
public class BaekJoon_1212 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String oct = br.readLine();
		int octLen = oct.length();
		
		int biLen = octLen * 3;
		int[] binary = new int[biLen];
		
		int idx = biLen - 1;
		for (int i=octLen-1; i>=0; i--) {
			int octNum = (int)(oct.charAt(i) - '0');
			binary[idx - 2] =  (octNum >= 4) ? 1 : 0;
			octNum %= 4;
			binary[idx - 1] =  (octNum >= 2) ? 1 : 0;
			octNum %= 2;
			binary[idx] =  (octNum == 1) ? 1 : 0;
			idx -= 3;
		}
		
		StringBuilder sb = new StringBuilder();
		boolean flag = false;
		for (int i=0; i<biLen; i++) {
			if (!flag && binary[i] == 1) flag = true;
			if (flag) sb.append(binary[i]);
		}
		if (sb.length() == 0) System.out.println(0);
		else System.out.println(sb);
		br.close();
	}

}
