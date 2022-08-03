package function;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 한수
public class BaekJoon_1065 {
	public static boolean isHansu(String numStr) {
		if (numStr.length() < 3) return true;
		
		int diff = numStr.charAt(0) - numStr.charAt(1);
		for (int i=1; i<numStr.length()-1; i++) {
			if (numStr.charAt(i) - numStr.charAt(i+1) != diff) return false; 
		}
		return true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = 0;
		int N = Integer.parseInt(br.readLine());
		for (int i=1; i<=N; i++) {
			String numStr = Integer.toString(i);
			if (isHansu(numStr)) {
				cnt++;
			}
		}
		System.out.println(cnt);
		br.close();
	}

}
