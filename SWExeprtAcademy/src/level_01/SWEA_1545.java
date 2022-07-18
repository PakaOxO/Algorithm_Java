package level_01;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 거꾸로 출력해 보아요 
public class SWEA_1545 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] arr = new String[N+1];
		for (int i=0, j=N; i<=N; i++, j--) {
			arr[i] = Integer.toString(j);
		}
		System.out.println(String.join(" ", arr));
	}

}
