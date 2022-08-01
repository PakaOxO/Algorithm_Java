package loop;

import java.util.Scanner;

// 합
public class BaekJoon_8393 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		System.out.println(num * (num + 1) / 2);
		sc.close();
	}

}
