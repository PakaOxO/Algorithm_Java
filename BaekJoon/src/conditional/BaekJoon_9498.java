package conditional;

import java.util.Scanner;

// 시험 성적
public class BaekJoon_9498 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int score = sc.nextInt();
		String grade = (score >= 90) ? "A" : ((score >=80) ? "B" : ((score >= 70) ? "C" : ((score >= 60) ? "D" : "F")));
		System.out.println(grade);
		sc.close();
	}

}
