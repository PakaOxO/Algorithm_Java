package string;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_11656, 접미사 배열
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 문자열을 앞에서부터 하나씩 잘라가며 배열에 담은 뒤 해당 배열을 정렬
 *
 */
public class BaekJoon_11656 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] cArr = br.readLine().toCharArray();
		
		int len = cArr.length;
		String[] sArr = new String[len];
		
		String str = "";
		for (int i=len-1; i>=0; i--) {
			str = cArr[i] + str;
			sArr[i] = str;
		}
		Arrays.sort(sArr);
		
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<len; i++) {
			sb.append(sArr[i]).append("\n");
		}
		System.out.print(sb);
		br.close();
	}

}
