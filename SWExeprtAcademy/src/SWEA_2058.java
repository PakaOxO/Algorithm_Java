

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 자릿수 더하기
public class SWEA_2058 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int sum = 0;
		
		while (num > 0) {
			sum += num % 10;
			num = (int)Math.floor(num / 10);
		}
		System.out.println(sum);
	}

}
