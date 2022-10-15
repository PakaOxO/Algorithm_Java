package implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// ������ 2
public class BaekJoon_2567 {
	static StringTokenizer st;
	static boolean[][] isFilled;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		isFilled = new boolean[102][102];
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())+1;
			int y = Integer.parseInt(st.nextToken())+1;
			for (int j=y; j<y+10; j++) {
				for (int k=x; k<x+10; k++) {					
					if (!isFilled[j][k]) isFilled[j][k] = true;
				}
			}
		}
		boolean prevR = false;
		boolean prevC = false;
		long answer = 0;
		for (int row=0; row<102; row++) {
			for (int col=0; col<102; col++) {
				boolean currC = isFilled[row][col];
				if (prevC != currC) answer++;
				prevC = currC;
				
				boolean currR = isFilled[col][row];
				if (prevR != currR) answer++;
				prevR = currR;
			}
		}
		System.out.println(answer);
		br.close();
	}

}
