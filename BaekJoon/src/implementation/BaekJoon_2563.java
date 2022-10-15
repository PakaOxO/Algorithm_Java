package implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// ������
public class BaekJoon_2563 {
	
	static boolean[][] isFilled;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		isFilled = new boolean[100][100];
		int answer = 0;
		for (int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			for (int j=y; j<y+10; j++) {
				for (int k=x; k<x+10; k++) {
					if (!isFilled[j][k]) {
						isFilled[j][k] = true;
						answer++;
					}
				}
			}
		}
		System.out.println(answer);
		br.close();
	}

}
