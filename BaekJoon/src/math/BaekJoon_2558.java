package math;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// A + B - 2
public class BaekJoon_2558 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		System.out.println(A + B);
		br.close();
	}

}
