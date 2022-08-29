package level_03;

import java.io.*;
import java.util.*;

// 수의 새로운 연산
public class SWEA_1493_2 {
	
	static int[] getCoord(int num) {
		int coordX = 0, coordY = 0;
		for (int i=1; i<200; i++) {
			int from = (i * i - i + 2) / 2;
			int to = i * (i + 1) / 2;
			
			if (num < from || num > to ) continue;
			coordX = 1;
			coordY = i;
			while (from < num) {
				coordX++;
				coordY--;
				from++;
			}
		}
		return new int[] { coordX, coordY };
	}
	
	static int getNum(int x, int y) {
		int line = x + y - 1;
		int from = (line * line - line + 2) / 2;
		
		return from + x - 1;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] xy1 = getCoord(Integer.parseInt(st.nextToken()));
			int[] xy2 = getCoord(Integer.parseInt(st.nextToken()));
			
			int x = xy1[0] + xy2[0];
			int y = xy1[1] + xy2[1];
			
			sb.append("#").append(tc).append(" ").append(getNum(x, y)).append("\n");
		}
		System.out.print(sb);
		br.close();
	}

}
