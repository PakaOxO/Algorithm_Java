package string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 아스키 코드
public class BaekJoon_11654 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int ascii = br.readLine().toCharArray()[0];
		System.out.println(ascii);
		br.close();
	}

}
