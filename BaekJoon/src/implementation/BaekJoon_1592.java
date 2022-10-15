package implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// �����̿� ģ����
public class BaekJoon_1592 {
	
	static int[] cnt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		cnt = new int[N];
		cnt[0]++;
		
		int pointer = 0;
		int loop = 0;
		while (true) {
			if (cnt[pointer] == M) break;
			if (cnt[pointer] % 2 == 0) {
				pointer = (pointer - L < 0) ? pointer - L + N : pointer - L;
			} else {
				pointer = (pointer + L) % N;
			}
			cnt[pointer]++;
			loop++;
		}
		System.out.println(loop);
		br.close();
	}

}
