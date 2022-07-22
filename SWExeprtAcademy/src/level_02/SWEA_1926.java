package level_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 간단한 369게임
public class SWEA_1926 {
	static String[] arr = { "", "", "", "-", "", "", "-", "", "", "-" };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String result = "";
		for (int i=1; i<=N; i++) {
			String numStr = Integer.toString(i);
			for (int j=0; j<numStr.length(); j++) {
				if (numStr.contains("3") || numStr.contains("6") || numStr.contains("9")) {
					String[] numArr = numStr.split("");
					for (int k=0; k<numArr.length; k++) {
						int num = Integer.parseInt(numArr[k]);
						numStr = numStr.replaceAll(numArr[k], arr[num]);
					}
				}
			}
			
			result += (numStr + " ");
		}
		System.out.println(result.trim());
		br.close();
	}

}
