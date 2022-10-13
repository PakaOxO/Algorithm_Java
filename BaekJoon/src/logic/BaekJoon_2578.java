package logic;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_2578, 빙고
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 
 *
 */
public class BaekJoon_2578 {
	static int[][] board = new int[5][5];
	static int[][] pos;
	
	static int check() {
		int bingo = 0;
		
		int cCnt1 = 0;
		int cCnt2 = 0;
		for (int i=0; i<5; i++) {
			int hCnt = 0;
			int vCnt = 0;
			for (int j=0; j<5; j++) {
				if (board[i][j] == 0) hCnt++;
				if (board[j][i] == 0) vCnt++;
				if (i == j && board[i][j] == 0) cCnt1++;
				if (i + j == 4 && board[i][j] == 0) cCnt2++;
			}
			
			if (hCnt == 5) bingo++;
			if (vCnt == 5) bingo++;
		}
		if (cCnt1 == 5) bingo++;
		if (cCnt2 == 5) bingo++;
		
		return bingo;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		pos = new int[26][2];
		for (int i=0; i<5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j=0; j<5; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				pos[board[i][j]][0] = i;
				pos[board[i][j]][1] = j;
			}
		}
		
		int cnt = 0;
		loop:
		for (int i=0; i<5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j=0; j<5; j++) {
				cnt++;
				int num = Integer.parseInt(st.nextToken());
				board[pos[num][0]][pos[num][1]] = 0;
				
				if (cnt >= 5 && check() >= 3) break loop;
			}
		}
		br.close();
		System.out.println(cnt);
	}

}
