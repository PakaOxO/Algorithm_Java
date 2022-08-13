package string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// IOIOI
public class BaekJoon_5525 {
	static StringBuilder ioi = new StringBuilder("IOI");

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		char[] arr = br.readLine().toCharArray();
		
		int cnt = 0;
		int answer = 0;
		for (int i=0; i<M - 2; i++) {
			if (arr[i] == 'I' && arr[i+1] == 'O' && arr[i+2] == 'I') {
				cnt++;
				if (cnt == N) {
					answer++;
					cnt--;
				}
				i++;
			} else {
				cnt = 0;
			}
		}
		System.out.println(answer);
		br.close();
	}

}