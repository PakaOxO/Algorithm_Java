import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 가장 큰 금민수 재풀이
public class Test {
	
	static int DFS(int num, int N) {
		int result = num;
		if (num * 10 + 7 <= N) {
			result = DFS(num * 10 + 7, N);
		}
		if (num * 10 + 4 <= N) {
			result = Math.max(result, DFS(num * 10 + 4, N));
		}
		return result;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int answer = DFS(0, N);
		System.out.println(answer);
		br.close();
	}

}
