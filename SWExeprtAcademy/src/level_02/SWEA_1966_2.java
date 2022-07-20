package level_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//숫자를 정렬하자 (내장 함수 사용)
public class SWEA_1966_2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCnt = Integer.parseInt(br.readLine());
		for (int i=0; i<testCnt; i++) {
			int len = Integer.parseInt(br.readLine());
			String[] input = br.readLine().split(" ");
			int[] sorted = new int[len];
			
			for (int j=0; j<len; j++) {
				sorted[j] = Integer.parseInt(input[j]);
			}
			Arrays.sort(sorted);
			
			String result = "";
			for (int k=0; k<len; k++) {
				result += (Integer.toString(sorted[k]) + " ");
			}
			
			System.out.printf("#%d %s\n", i + 1, result.trim());
		}
	}

}
