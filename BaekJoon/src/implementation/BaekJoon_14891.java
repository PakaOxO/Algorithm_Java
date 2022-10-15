package implementation;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_14891, 톱니바퀴
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 
 *
 */
public class BaekJoon_14891 {
	static char[][] gear;
	static int[] pointer;
	static int rCnt;
	static int[] check;
	
	static int right(int gNo) {
		return (pointer[gNo] + 2) % 8;
	}
	
	static int left(int gNo) {
		return (pointer[gNo] + 6) % 8;
	}
	
	static void rotate(int gNo, int dir) {
		if (dir == -1) {
			pointer[gNo] = (pointer[gNo] + 1) % 8;
		} else {
			pointer[gNo]--;
			if (pointer[gNo] < 0) pointer[gNo] += 8;;
		}
	}
	
	static void check(int gNo, int dir) {
		check = new int[4];
		check[gNo] = dir;
		
		if (gNo == 0) {
			if (gear[0][right(0)] != gear[1][left(1)]) {
				check[1] = dir*-1;
				if (gear[1][right(1)] != gear[2][left(2)]) {
					check[2] = dir;
					if (gear[2][right(2)] != gear[3][left(3)]) {
						check[3] = dir*-1;
					}
				}
			}
		} else if (gNo == 1) {
			if (gear[1][right(1)] != gear[2][left(2)]) {
				check[2] = dir*-1;
				if (gear[2][right(2)] != gear[3][left(3)]) {
					check[3] = dir;
				}
			}
			
			if (gear[1][left(1)] != gear[0][right(0)]) {
				check[0] = dir*-1;
			}
		} else if (gNo == 2) {
			if (gear[2][right(2)] != gear[3][left(3)]) {
				check[3] = dir*-1;
			}
			
			if (gear[2][left(2)] != gear[1][right(1)]) {
				check[1] = dir*-1;
				if (gear[1][left(1)] != gear[0][right(0)]) {
					check[0] = dir;
				}
			}
		} else {
			if (gear[3][left(3)] != gear[2][right(2)]) {
				check[2] = dir*-1;
				if (gear[2][left(2)] != gear[1][right(1)]) {
					check[1] = dir;
					if (gear[1][left(1)] != gear[0][right(0)]) {
						check[0] = dir*-1;
					}
				}
			}
		}
	}
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		gear = new char[4][8];
		gear[0] = br.readLine().toCharArray();
		gear[1] = br.readLine().toCharArray();
		gear[2] = br.readLine().toCharArray();
		gear[3] = br.readLine().toCharArray();
		
		pointer = new int[4];

		rCnt = Integer.parseInt(br.readLine());
		
		for (int i=0; i<rCnt; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int gNo = Integer.parseInt(st.nextToken()) - 1;
			int dir = Integer.parseInt(st.nextToken());
			
			check(gNo, dir);
			for (int j=0; j<4; j++) {
				if (check[j] == 0) continue;
				rotate(j, check[j]);
			}
		}
		br.close();
		
		int answer = 0;
		if (gear[0][pointer[0]] == '1') answer += 1;
		if (gear[1][pointer[1]] == '1') answer += 2;
		if (gear[2][pointer[2]] == '1') answer += 4;
		if (gear[3][pointer[3]] == '1') answer += 8;
		
		System.out.println(answer);
	}

}
