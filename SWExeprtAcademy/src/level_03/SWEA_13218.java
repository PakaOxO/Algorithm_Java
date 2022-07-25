package level_03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 조별과제
public class SWEA_13218 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		String result = "";
		for (int i=1; i<=T; i++) {
			result += ("#" + i + " " + (Integer.parseInt(br.readLine()) / 3) + "\n");
		}
		System.out.println(result);
		br.close();
	}

}
