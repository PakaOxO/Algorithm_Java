package bruteForce;

import java.io.*;

/**
 * BaekJoon_2231, 분해합
 * @author kevin-Arpe
 *
 * Sketch Idea
 * 	1. 숫자 N의 생성자의 조건은 다음과 같다.
 * 		1.1 생성자는 N보다 작은 수이다.
 * 		1.2 생성자와 생성자를 이루는 숫자의 합은 N이다.
 * 	2. 이 조건을 이루는 수를 찾기 위해서 2가지 아이디어를 떠올렸다.
 * 		2.1 N보다 작은 수들 중에서 -1씩 감소하며 만족하는 숫자가 있는지 탐색.
 * 		2.2 N보다 작은 수에서 해당 조건을 만족하는 숫자를 이진 탐색 -> 이진탐색 불가(숫자가 크더라도 중간에 작은 숫자가 섞여있으면 자리수 합은 작아질 수 있음)
 * 
 * 	3. 이진탐색은 불가하다는 반례를 찾았기 때문에 브루트포스로 1부터 증가시켜가며
 * 		처음으로 생성자 조건에 부합하는 숫자를 출력하도록 수정했다.
 * 	4. 반복문에서 부합하는 숫자가 없었다면 0을 출력한다.
 * 
 */
public class BaekJoon_2231 {
	
	static int divSum(int num) {
		int sum = num;
		while (num > 0) {
			sum += num % 10;
			num /= 10;
		}
		return sum;
	}
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		boolean flag = false;
		for (int i=1; i<=N; i++) {
			if (divSum(i) == N) {
				System.out.println(i);
				flag = true;
				break;
			}
		}
		if (!flag) System.out.println(0);
		br.close();
	}

}
