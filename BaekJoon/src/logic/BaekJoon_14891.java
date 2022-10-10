package logic;

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
	static int[] gear;
	static int rCnt;
	static int[] check;
	
	static void rotate(int gNo, int dir) {
		if (dir == -1) {
			if ((gear[gNo] & (1 << 7)) > 0) {
				gear[gNo] = gear[gNo] << 1;
				gear[gNo] += 1;
				gear[gNo] %= (1 << 8);
			} else {
				gear[gNo] = gear[gNo] << 1;
				gear[gNo] %= (1 << 8);
			}
		} else {
			if ((gear[gNo] & 1) > 0) {
				gear[gNo] = gear[gNo] >> 1;
				gear[gNo] += (1 << 7);
			} else {
				gear[gNo] = gear[gNo] >> 1;
			}
		}
	}
	
	static void check(int gNo, int dir) {
		check = new int[4];
		check[gNo] = dir;
		
	}
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		gear = new int[4];
		gear[0] = Integer.parseInt(br.readLine(), 2);
		gear[1] = Integer.parseInt(br.readLine(), 2);
		gear[2] = Integer.parseInt(br.readLine(), 2);
		gear[3] = Integer.parseInt(br.readLine(), 2);

		rCnt = Integer.parseInt(br.readLine());
		
		for (int i=0; i<rCnt; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int gNo = Integer.parseInt(st.nextToken()) - 1;
			int dir = Integer.parseInt(st.nextToken());
			
			check(gNo, dir);
			for (int j=0; j<4; j++) {
				if (check[j] == 0) continue;
				rotate(j, dir);
			}
		}
		br.close();
		
		for (int g : gear) System.out.println(Integer.toBinaryString(g));
		int answer = 0;
		if ((gear[0] & (1 << 7)) > 0) answer += 1;
		if ((gear[1] & (1 << 7)) > 0) answer += 2;
		if ((gear[2] & (1 << 7)) > 0) answer += 4;
		if ((gear[3] & (1 << 7)) > 0) answer += 8;
		
		System.out.println(answer);
	}

}
