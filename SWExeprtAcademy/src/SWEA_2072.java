import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 홀수만 더하기 
public class SWEA_2072 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCnt = Integer.parseInt(br.readLine());
		for (int i=0; i<testCnt; i++) {
			String[] arr = br.readLine().split(" ");
			int sum = 0;
			for (int j=0; j<10; j++) {
				int num = Integer.parseInt(arr[j]);
				if (num % 2 != 0) sum += num;
			}
			System.out.printf("#%d %d\n", i + 1, sum);
		}
	}

}
