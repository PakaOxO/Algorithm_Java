package bruteForce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

// 카드 놓기
public class BaekJoon_5568 {
	static int N, K;
	static int[] arr;
	static boolean[] isVisited;
	static Set<Integer> set;
	
	static void getNumber(int num, int cnt) {
		if (cnt == K) {
			set.add(num);
			return;
		}
		for (int i=0; i<N; i++) {
			if (isVisited[i]) continue;
			
			isVisited[i] = true;
			int next = 0;
			if (arr[i] >= 10) next = num * 100 + arr[i];
			else next = num * 10 + arr[i];
			getNumber(next, cnt + 1);
			isVisited[i] = false;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		arr = new int[N];
		isVisited = new boolean[N];
		for (int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		set = new HashSet<>();
		getNumber(0, 0);
		System.out.println(set.size());
		br.close();
	}

}
