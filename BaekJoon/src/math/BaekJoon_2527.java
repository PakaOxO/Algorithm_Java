package math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 직사각형 
public class BaekJoon_2527 {
	
	static int checkX, checkY;
	
	static void checkXY(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
		if (x2 > x4) {
			checkX = (x4 < x1) ? 0 : (x4 == x1) ? 1 : 2;
		} else {
			checkX = (x2 < x3) ? 0 : (x2 == x3) ? 1 : 2;
		}
		if (y2 > y4) {
			checkY = (y4 < y1) ? 0 : (y4 == y1) ? 1 : 2;
		} else {
			checkY = (y2 < y3) ? 0 : (y2 == y3) ? 1 : 2;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int i=0; i<4; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken()), y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken()), y2 = Integer.parseInt(st.nextToken());
			int x3 = Integer.parseInt(st.nextToken()), y3 = Integer.parseInt(st.nextToken());
			int x4 = Integer.parseInt(st.nextToken()), y4 = Integer.parseInt(st.nextToken());
			
			checkX = -1;
			checkY = -1;
			if (x2 >= x1 && x4 >= x3) checkXY(x1, y1, x2, y2, x3, y3, x4, y4);
			else if (x2 >= x1 && x3 >= x4) checkXY(x1, y1, x2, y2, x4, y4, x3, y3);
			else if (x1 >= x2 && x4 >= x3) checkXY(x2, y2, x1, y1, x3, y3, x4, y4);
			else if (x1 >= x2 && x3 >= x4) checkXY(x2, y2, x1, y1, x4, y4, x3, y3);
			
			if (checkX == 0 || checkY == 0) System.out.println("d");
			else if ((checkX == 1 && checkY == 2) || (checkX == 2  && checkY == 1)) System.out.println("b");
			else if (checkX == 1 || checkY == 1) System.out.println("c");
			else if (checkX == 2 && checkY == 2) System.out.println("a");
		}
	}

}
