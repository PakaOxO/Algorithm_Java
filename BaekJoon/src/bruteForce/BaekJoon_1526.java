package bruteForce;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 가장 큰 금민수
public class BaekJoon_1526 {
	private static int N;
	
	public static int DFS(int num) {
		int result = num;
		if (num * 10 + 4 <= N) result = DFS(num * 10 + 4);
		if (num * 10 + 7 <= N) result = Math.max(result, DFS(num * 10 + 7));
		
		return result;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		System.out.println(DFS(0));
		br.close();
	}

}
