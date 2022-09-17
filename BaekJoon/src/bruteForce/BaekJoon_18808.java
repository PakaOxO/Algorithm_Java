package bruteForce;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_18808, 스티커 붙이기
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 가장 우선적으로 붙이는 위치는 위쪽, 그리고 왼쪽이므로 반복문으로 좌상부터 우하까지 탐색 
 * 	2. 입력받은 스티커 순으로 탐색을 진행하면서 붙일 수 있으면 붙이고 붙일 수 없다면 90도 회전시켜가며 붙여봄
 * 	3. 하나라도 붙일 수 있으면 해당 스티커 반복문을 종료하고 continue로 다음 스티커로 넘어
 * 	4. 	** 스티커를 회전시키는 로직을 직접 회전시키지 않고 배열 탐색의 방법을 수정 적용하려니 너무 힘들었다..
 * 			그냥 90도 회전한 배열을 새로 만드는 편이 나았을지도... 
 *
 */
public class BaekJoon_18808 {
	static int N, M, K;
	static int[][][] stickers;
	static int[][] board;
	
	static boolean check(int r, int c, int sNo, int degree) {
		if (degree == 0) {
			if (r + stickers[sNo].length > N) return false;
			if (c + stickers[sNo][0].length > M) return false;
			for (int i=0; i<stickers[sNo].length; i++) {
				for (int j=0; j<stickers[sNo][i].length; j++) {
					if (stickers[sNo][i][j] == 0) continue;
					if (board[r+i][c+j] == 1) return false;
				}
			}
		} else if (degree == 90) {
			if (r + stickers[sNo][0].length > N) return false;
			if (c + stickers[sNo].length > M) return false;
			for (int i=0; i<stickers[sNo][0].length; i++) {
				for (int j=0; j<stickers[sNo].length; j++) {
					if (stickers[sNo][stickers[sNo].length-1-j][i] == 0) continue;
					if (board[r+i][c+j] == 1) return false;;
				}
			}
		} else if (degree == 180) {
			if (r + stickers[sNo].length > N) return false;
			if (c + stickers[sNo][0].length > M) return false;
			for (int i=0; i<stickers[sNo].length; i++) {
				for (int j=0; j<stickers[sNo][0].length; j++) {
					if (stickers[sNo][stickers[sNo].length-1-i][stickers[sNo][0].length-1-j] == 0) continue;
					if (board[r+i][c+j] == 1) return false;;
				}
			}
		} else {
			if (r + stickers[sNo][0].length > N) return false;
			if (c + stickers[sNo].length > M) return false;
			for (int i=0; i<stickers[sNo][0].length; i++) {
				for (int j=0; j<stickers[sNo].length; j++) {
					if (stickers[sNo][j][stickers[sNo][0].length-1-i] == 0) continue;
					if (board[r+i][c+j] == 1) return false;
				}
			}
		}
		return true;
	}
	
	static int fill(int r, int c, int sNo, int degree) {
		int cnt = 0;
		if (degree == 0) {
			for (int i=0; i<stickers[sNo].length; i++) {
				for (int j=0; j<stickers[sNo][i].length; j++) {
					if (stickers[sNo][i][j] == 0) continue;
					board[r+i][c+j] = 1;
					cnt++;
				}
			}
		} else if (degree == 90) {
			for (int i=0; i<stickers[sNo][0].length; i++) {
				for (int j=0; j<stickers[sNo].length; j++) {
					if (stickers[sNo][stickers[sNo].length-1-j][i] == 0) continue;
					board[r+i][c+j] = 1;
					cnt++;
				}
			}
		} else if (degree == 180) {
			for (int i=0; i<stickers[sNo].length; i++) {
				for (int j=0; j<stickers[sNo][0].length; j++) {
					if (stickers[sNo][stickers[sNo].length-1-i][stickers[sNo][0].length-1-j] == 0) continue;
					board[r+i][c+j] = 1;
					cnt++;
				}
			}
		} else {
			for (int i=0; i<stickers[sNo][0].length; i++) {
				for (int j=0; j<stickers[sNo].length; j++) {
//					if (stickers[sNo][j][i] == 0) continue;
					if (stickers[sNo][j][stickers[sNo][0].length-1-i] == 0) continue;
					board[r+i][c+j] = 1;
					cnt++;
				}
			}
		}
		return cnt;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		stickers = new int[K][][];
		
		for (int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			stickers[i] = new int[H][W];
			for (int j=0; j<H; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k=0; k<W; k++) {
					stickers[i][j][k] = Integer.parseInt(st.nextToken());
				}
			}
		}
		
		int answer = 0;
		board = new int[N][M];
		
		
		loop:
		for (int i=0; i<stickers.length; i++) {
			for (int r=0; r<N; r++) {
				for (int c=0; c<M; c++) {
					if (check(r, c, i, 0)) {
						answer += fill(r, c, i, 0);
						continue loop;
					}
				}
			}
			
			for (int r=0; r<N; r++) {
				for (int c=0; c<M; c++) {
					if (check(r, c, i, 90)) {
						answer += fill(r, c, i, 90);
						continue loop;
					}
				}
			}
			
			for (int r=0; r<N; r++) {
				for (int c=0; c<M; c++) {
					if (check(r, c, i, 180)) {
						answer += fill(r, c, i, 180);
						continue loop;
					}
				}
			}
			
			for (int r=0; r<N; r++) {
				for (int c=0; c<M; c++) {
					if (check(r, c, i, 270)) {
						answer += fill(r, c, i, 270);
						continue loop;
					}
				}
			}
		}
		
		
		System.out.println(answer);
		br.close();
	}

}
