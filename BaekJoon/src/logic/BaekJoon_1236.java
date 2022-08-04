package logic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 성 지키기
public class BaekJoon_1236 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		String[][] castle = new String[N][];
		int horzCnt = 0;
		for (int i=0; i<N; i++) {
			castle[i] = br.readLine().split("");
			boolean hasPatrol = true;
			for (int j=0; j<M; j++) {
				if (castle[i][j].equals("X")) {
					hasPatrol = false;
					break;
				}
			}
			if (hasPatrol) horzCnt++;
		}
		int vertCnt = 0;
		for (int i=0; i<M; i++) {
			boolean hasPatrol = true;
			for (int j=0; j<N; j++) {
				if (castle[j][i].equals("X")) {
					hasPatrol = false;
					break;
				}
			}
			if (hasPatrol) vertCnt++;
		}
		int result = (vertCnt > horzCnt) ? vertCnt : horzCnt;
		System.out.println(result);
		br.close();
	}

}
