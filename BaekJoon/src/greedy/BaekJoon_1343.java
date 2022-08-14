package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 폴리오미노
public class BaekJoon_1343 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		input = input.replaceAll("XXXX", "AAAA");
		input = input.replaceAll("XX", "BB");
		String temp = input.replaceAll("X", "");
		if (temp.length() < input.length()) System.out.println(-1);
		else System.out.println(input);
		br.close();
	}

}
