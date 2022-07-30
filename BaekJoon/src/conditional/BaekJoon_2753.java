package conditional;

import java.util.Scanner;

// 윤년
public class BaekJoon_2753 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int year = sc.nextInt();
		int isLeapYear = ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) ? 1 : 0;
		System.out.println(isLeapYear);
		sc.close();
	}

}
