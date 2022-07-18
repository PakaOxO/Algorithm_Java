

import java.util.Scanner;
import java.util.Arrays;

// 중간값 찾기 
public class SWEA_2063
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] numArr = new int[N];
		for (int i=0; i<N; i++) {
			numArr[i] = sc.nextInt();
		}
		Arrays.sort(numArr);
		System.out.println(numArr[(N - 1) / 2]);
		
		sc.close();
	}
}