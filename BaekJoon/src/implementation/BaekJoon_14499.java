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
 * 		1.1 먼저 0~5 인덱스를 가진 배열에 0은 아래쪽, 5는 위쪽, 1~4는 각각 동서남북 숫자를 담음
 * 		1.2 굴리는 방향은 동서북남으로 4가지이고, 각각에 대해 굴린 뒤 바라보는 방향은 정해져있으므로 해당 부분을 구현
 * 
 * 	2. 남은 로직은 문제에서 주어진대로 작성하면 될 듯(이동해서 맵에 숫자가 0이면 ... 0이 아니면 ... )
 * 
 */
public class BaekJoon_14499 {
	static int N, M, x, y, K;
	static int[] dice = { 0, 0, 0, 0, 0, 0 };
	static int[][] map;
	static int[][] drc = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };
	static StringBuilder sb;
	
	static void move(int dir) {
	    int nr = x + drc[dir][0];
	    int nc = y + drc[dir][1];
	    if (nr < 0 || nc < 0 || nr >= N || nc >= M) return;
	    
	    int temp = -1;
	    switch (dir) {
	        case 0:
	            // 동 -> 아래, 아래 -> 서, 서 -> 위, 위 -> 동
	            temp = dice[1];
	            dice[1] = dice[5];
	            dice[5] = dice[2];
	            dice[2] = dice[0];
	            dice[0] = temp;
	            break;
	        case 1:
	            // 서 -> 아래, 아래 -> 동, 동 -> 위, 위 -> 서
	            temp = dice[2];
	            dice[2] = dice[5];
	            dice[5] = dice[1];
	            dice[1] = dice[0];
	            dice[0] = temp;
	            break;
	        case 2:
	            // 북 -> 아래, 아래 -> 남, 남 -> 위, 위 -> 북 
	            temp = dice[4];
	            dice[4] = dice[5];
	            dice[5] = dice[3];
	            dice[3] = dice[0];
	            dice[0] = temp;
	            break;
	        case 3:
	            // 남 -> 아래, 아래 -> 북, 북 -> 위, 위 -> 남
	            temp = dice[3];
	            dice[3] = dice[5];
	            dice[5] = dice[4];
	            dice[4] = dice[0];
	            dice[0] = temp;
	            break;
	    }
	    
	    if (map[nr][nc] == 0) {
	        map[nr][nc] = dice[0];
	    } else {
	        dice[0] = map[nr][nc];
	        map[nr][nc] = 0;
	    }
	    
	    x = nr;
	    y = nc;
	    sb.append(dice[5]).append("\n");
	}

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
		
		sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<K; i++) {
		    int dir = Integer.parseInt(st.nextToken()) - 1;
		    move(dir);
		}
		br.close();
		System.out.print(sb);
	}

}
