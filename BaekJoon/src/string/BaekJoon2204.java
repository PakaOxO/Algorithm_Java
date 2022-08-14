package string;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

// 도비의 난독증 테스트
public class BaekJoon2204 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N;
		while ((N = Integer.parseInt(br.readLine())) != 0) {
			String[] arr = new String[N];
			String[] arr2 = new String[N];
			for (int i=0; i<N; i++) {
				String input = br.readLine();
				arr[i] = input;
				arr2[i] = input.toLowerCase();
			}
			Arrays.sort(arr2);
			for (int i=0; i<N; i++) {
				if (arr2[0].equals(arr[i].toLowerCase())) sb.append(arr[i] + "\n");
			}
		}
		System.out.println(sb.toString().trim());
		br.close();
	}

}
