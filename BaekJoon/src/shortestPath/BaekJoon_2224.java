package shortestPath;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_2224, 명제 증명
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. A->B 라는 명제가 주어진다면 A에서 B로 가는 유향 그래프를 그린다.
 * 	2. 주어질 수 있는 알파벳은 A-Z, a-z이므로 총 52x52의 dist 배열을 만들어 연결 정보 체크
 * 	3. 모든 노드에 대해 최단 거리를 구하는 플로이드-워셜을 사용하여 i, j가 다를 때 서로 연결되어 있으면 증명된 명제
 *
 */
public class BaekJoon_2224 {
	static final int INF = Integer.MAX_VALUE;
	static int[][] dist;
	static boolean[][] adjArr;
	
	static int getIdx(char c) {
		if (c >= 'A' && c <= 'Z') {
			return (int)(c - 'A');
		}
		return (int)(c - 'a') + 26;
	}
	
	static char getChar(int idx) {
		if (idx < 26) {
			return (char)(idx + 'A');
		}
		return (char)(idx - 26 + 'a');
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		adjArr = new boolean[52][52];
		for (int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char s = st.nextToken().charAt(0);
			st.nextToken();
			char e = st.nextToken().charAt(0);
			adjArr[getIdx(s)][getIdx(e)] = true;
		}
		br.close();
		
		dist = new int[52][52];
		for (int[] d : dist) Arrays.fill(d, INF);
		
		for (int k=0; k<52; k++) {
			for (int i=0; i<52; i++) {
				if (i == k) continue;
				for (int j=0; j<52; j++) {
					if (j == i || j == k) continue;
					if (adjArr[i][k] && adjArr[k][j]) adjArr[i][j] = true;
				}
			}
		}
		
		int cnt = 0;
		StringBuilder answer = new StringBuilder();
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<52; i++) {
			for (int j=0; j<52; j++) {
				if (i == j) continue;
				if (adjArr[i][j]) {
					cnt++;
					sb.append(getChar(i)).append(" => ").append(getChar(j)).append("\n");
				}
			}
		}
		answer.append(cnt).append("\n").append(sb);
		System.out.print(answer);
	}

}
