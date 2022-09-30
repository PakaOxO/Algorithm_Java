package bruteForce;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_17135, 캐슬 디펜스
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 먼저 궁수를 배치할 열, 3개를 고름
 * 	2. 그 다음부턴 궁수의 공격 - 적의 이동을 반복
 * 	3. 궁수의 공격
 * 		3.1 공격은 최대 사거리가 정해져 있으므로 거리가 가까울 수록, 그리고 왼쪽에 있을 수록 우선 공격하도록 설정
 * 	4. 적의 이동은 직접 원본 배열을 수정하지 말고, 적의 위치를 ArrayList에 담은 다음 위치를 이동시키도록?
 * 		4.1 적이 죽거나 성에 도착하면 맨 처음 카운팅한 적의 수에서 하나씩 줄여줌
 * 		4.2 적의 수가 0이되면 로직 종료
 *
 */
public class BaekJoon_17135 {
	static int N, M, D, totalCnt, eCnt, dCnt, answer;
	static int[][] copyMap;
	static int[][] map, archor;
	static int[][] drc = { { 0, -1 }, { -1, 0 }, { 0, 1 } }; // 왼, 위, 우
	
	static void getEnemy() {
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				copyMap[i][j] = map[i][j];
			}
		}
	}
	
	static void eMove() {
		for (int i=0; i<M; i++) {
			if (copyMap[archor[0][0] - 1][i] == 1) {
				copyMap[archor[0][0] - 1][i] = 0;
				eCnt--;
			}
		}
		for (int i=0; i<3; i++) {
			archor[i][0]--;
		}
	}
	
	static void attack() {
		Queue<int[]> q = new LinkedList<>();
		boolean[] isVisited = new boolean[3];
		int[][] pos = new int[3][2];
		int cnt = 0;
		for (int i=0; i<3; i++) {
			int sR = archor[i][0] - 1;
			int sC = archor[i][1];
			if (copyMap[sR][sC] == 1) {
				pos[cnt][0] = sR;
				pos[cnt][1] = sC;
				cnt++;
				isVisited[i] = true;
				continue;
			}
			q.offer(new int[] { sR, sC, i, 1 });
		}
		
		while (q.size() > 0) {
			if (cnt == 3) break;
			int[] curr = q.poll();
			
			for (int i=0; i<3; i++) {
				int nr = curr[0] + drc[i][0];
				int nc = curr[1] + drc[i][1];
				if (nr < 0 || nc < 0 || nc >= M || curr[3] + 1 > D || isVisited[curr[2]]) continue;
				
				if (copyMap[nr][nc] == 1) {
					pos[cnt][0] = nr;
					pos[cnt][1] = nc;
					cnt++;
					isVisited[curr[2]] = true;
					if (cnt == 3) break;
					continue;
				} else {
					if (curr[3] + 1 < D) q.offer(new int[] { nr, nc, curr[2], curr[3] + 1 });
				}
			}
		}
		
		for (int i=0; i<cnt; i++) {
			if (copyMap[pos[i][0]][pos[i][1]] == 1) {
				dCnt++;
				copyMap[pos[i][0]][pos[i][1]] = 0;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		copyMap = new int[N][M];
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) totalCnt++;
			}
		}
		
		
		answer = 0;
		archor = new int[3][2];
		for (int i=0; i<M-2; i++) {
			for (int j=i+1; j<M-1; j++) {
				for (int k=j+1; k<M; k++) {
					archor[0][0] = archor[1][0] = archor[2][0] = N;
					archor[0][1] = i;
					archor[1][1] = j;
					archor[2][1] = k;
					getEnemy();
					
					dCnt = 0;
					eCnt = totalCnt;
					while (eCnt > 0) {
						attack();
						answer = Math.max(answer, dCnt);
						eMove();
						if (archor[0][0] == 0) break;
					}
				}
			}
		}
		System.out.println(answer);
	}

}
