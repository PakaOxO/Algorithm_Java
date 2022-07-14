

import java.util.Scanner;

// 1대1 가위바위보 
public class SWEA_1936
{
	public static char rcpResult(int a, int b) {
		int c = a - b;
		char result;
		if (c > 0) {
            result = (c == 1) ? 'A' : 'B';
		} else {
            result = (c == -1) ? 'B' : 'A';
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		String[] arr = input.split(" ");
		int a = Integer.parseInt(arr[0]);
		int b = Integer.parseInt(arr[1]);
		System.out.println(rcpResult(a, b));
		
		
		sc.close();
	}
}