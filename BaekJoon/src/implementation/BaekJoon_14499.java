package implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BaekJoon_14499, 주사위 굴리기
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 굴리는 로직을 구현하는 방식에 대해 고민해본 문제
 * 		1.1 먼저 0~5 인덱스를 가진 배열에 0은 위쪽, 5는 아래쪽, 1~4는 각각 북쪽부터 시계방향쪽 숫자를 담음
 * 		1.2 굴리는 방향은 상하좌우(또는 북남서좌)로 4가지이므로 각각에 대해 굴린 뒤 바라보는 방향은 정해져있으므로 해당 부분을 구현
 * 
 * 	2. 남은 로직은 문제에서 주어진대로 작성하면 될 듯(이동해서 맵에 숫자가 0이면 ... 0이 아니면 ... )
 * 
 *  3. 일단 사방탐색하고 큐에 담는다. 이때 방문체크핵서 방문했다면 큐에서 뺴서 스택에 넣고 스택을 초기화한다.
 *  
 *  4. 집에 가고 싶다.
 *  
 *  5. bfs ㄱㄱ
 */
public class BaekJoon_14499 {
	static int N, M, x, y, K;
	static int[] dice = { 0, 0, 0, 0, 0, 0 };
	static int[][] map;
	static int[] dr = {0, -1, 0, 1};
	static int[] dc = {-1, 0, 1, 0};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

}
