package io;

import java.util.Scanner;

// 곱셈
public class BaekJoon_2588 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int sum = 0;
		int result = A * B;
		while (B > 0) {
			int multiple = A * (B % 10);
			System.out.println(multiple);
			B /= 10;
		}
		System.out.println(result);
		sc.close();
	}

}
