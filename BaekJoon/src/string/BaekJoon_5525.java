package string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// IOIOI
public class BaekJoon_5525 {
	static String ioi = "IOI";

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for (int i=0; i<N; i++) {
			ioi += "OI";
		}
		int M = Integer.parseInt(br.readLine());
		String str = br.readLine();
		int ioiLen = ioi.length();
		for (int i=0; i<str.length(); i++) {
			for (int j=i+ioiLen; j>=i; j--) {
				
			}
		}
	}

}
