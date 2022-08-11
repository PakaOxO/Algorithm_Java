package string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// IOIOI (50Á¡)
public class BaekJoon_5525 {
	static StringBuilder ioi = new StringBuilder("IOI");

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for (int i=1; i<N; i++) {
			ioi.append("OI");
		}
		int M = Integer.parseInt(br.readLine());
		String str = br.readLine();
		int ioiLen = ioi.length();
		int result = 0;
		for (int i=0; i<M-ioiLen; i++) {
			boolean isSame = true;
			for (int j=0; j<ioiLen; j++) {
				if (str.charAt(i+j) != ioi.charAt(j)) {
					isSame = false;
					break;
				}
			}
			if (isSame) result++;
		}
		System.out.println(result);
	}

}