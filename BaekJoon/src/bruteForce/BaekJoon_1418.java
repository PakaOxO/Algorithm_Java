package bruteForce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BaekJoon_1418 {
	static boolean[] isPrime;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int N = Integer.parseInt(br.readLine());
	    int K = Integer.parseInt(br.readLine());
	    int[] arr = new int[N + 1];
	    
	    for (int i=2; i<=N; i++) {
	    	if (arr[i] != 0) continue;
	    	for (int j=i; j<=N; j+=i) {
	    		arr[j] = Math.max(arr[j], i);
	    	}
	    }
	    
	    int cnt = 0;
	    for (int i=1; i<=N; i++) {
	    	if (arr[i] <= K) cnt++;
	    }
	    System.out.println(Arrays.toString(arr));
	    System.out.println(cnt);
	    br.close();
	}

}
