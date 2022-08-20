package sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BaekJoon_5576 {
	static int[] W = new int[10];
	static int[] K = new int[10];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i=0; i<20; i++) {
			if (i < 10) W[i] = Integer.parseInt(br.readLine());
			else K[i - 10] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(W);
		Arrays.sort(K);
		System.out.println((W[9]+W[8]+W[7]) + " " + (K[9]+K[8]+K[7]));
		br.close();
	}

}
