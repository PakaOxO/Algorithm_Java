package solutions;

import java.util.Scanner;

// 간단한 압축풀기 
public class SWEA_1946 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		int testNo = 1;
		
		String[] arr = new String[10];
		while (testNo <= testcase) {
			int letterNo = sc.nextInt();
			int idx = 0;
			System.out.println("#" + testNo);
			for (int i=0; i<letterNo; i++) {
				String letter = sc.next();
				int letterCnt = Integer.parseInt(sc.nextLine().trim());
				while (idx < 10 && letterCnt > 0) {
					arr[idx++] = letter;
					letterCnt--;
					if (idx > 9) {
						System.out.println(String.join("", arr));
						arr = new String[10];
						idx = 0;
					}
				}
				
			}
			testNo++;
			if (idx > 0) {
				String result = "";
				for (int i=0; i<idx; i++) {
					result += arr[i];
				}
				System.out.println(result);
			}
		}
		sc.close();
	}

}
