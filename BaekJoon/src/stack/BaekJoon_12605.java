package stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 단어순서 뒤집기
public class BaekJoon_12605 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i=1; i<=N; i++) {
			String[] arr = br.readLine().split(" ");
			sb.append("Case #").append(i).append(": ");
			for (int j=arr.length-1; j>=0; j--) {
				sb.append(arr[j]);
				if (j > 0) sb.append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
		br.close();
	}

}
