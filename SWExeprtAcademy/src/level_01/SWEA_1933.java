import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

// 간단한 N의 약수
public class SWEA_1933 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String result = "";
		for (int i=1; i<=N/2; i++) {
			if (N % i == 0) result += (" " + i);
		}
		result += (" " + N);
		System.out.println(result.trim());
	}

}
