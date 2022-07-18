import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 더블더블 
public class SWEA_2019 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] arr = new String[N + 1];
		arr[0] = "1";
		
		for (int i=1; i<=N; i++) {
			arr[i] = Integer.toString(Integer.parseInt(arr[i-1]) * 2);
		}
		
		System.out.println(String.join(" " , arr));
	}

}
