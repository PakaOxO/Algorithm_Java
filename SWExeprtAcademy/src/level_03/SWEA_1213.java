package level_03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// String
public class SWEA_1213 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int i=1; i<=10; i++) {
			int N = Integer.parseInt(br.readLine());
			String keyword = br.readLine();
			String line = br.readLine();
			String[] arr = line.split(keyword);
			int cnt = arr.length - 1;
			if (line.substring(0, keyword.length()).equals(keyword)) cnt++;
			if (line.substring(line.length() - keyword.length(), line.length()).equals(keyword)) cnt++;
			sb.append("#" + N + " " + cnt + "\n");
		}
		System.out.println(sb.toString().trim());
		br.close();
	}

}
