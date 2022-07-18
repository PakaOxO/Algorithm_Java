package level_01;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 평균값 구하기 
public class SWEA_2071 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCnt = Integer.parseInt(br.readLine());
		for (int i=0; i<testCnt; i++) {
			String[] arr = br.readLine().split(" ");
			int sum = 0;
			double avg;
			for (String el : arr) {
				int num = Integer.parseInt(el);
				sum += num;
			}
			avg = Math.round(sum / 10.0);
			System.out.printf("#%d %.0f\n", i + 1, avg);
		}
	}


}
