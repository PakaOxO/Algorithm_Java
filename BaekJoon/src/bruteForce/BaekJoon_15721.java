package bruteForce;

import java.io.*;

/**
 * BaekJoon_15721, 번데기
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 길이가 A(사람 수)인 배열을 만들어 루프를 돌림
 * 	2. 하나의 문장이 끝날 때마다 round 수를 늘려 뻔*N, 데기*N 회 말하도록 라운드 수에 맞게 반복 하도록 한다.
 *
 */
public class BaekJoon_15721 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int A = Integer.parseInt(br.readLine());
		int T = Integer.parseInt(br.readLine());
		int type = Integer.parseInt(br.readLine());
		
		int round = 1;
		int man = 0;
		
		int bbunCnt = 0;
		int daegiCnt = 0;
		loop:
		while (true) {
			for (int i=0; i<2; i++) {
				bbunCnt++;
				if (type == 0 && bbunCnt == T) break loop;
				man = (man + 1) % A;
				
				daegiCnt++;
				if (type == 1 && daegiCnt == T) break loop;
				man = (man + 1) % A;
			}
			
			for (int i=0; i<round+1; i++) {
				bbunCnt++;
				if (type == 0 && bbunCnt == T) break loop;
				man = (man + 1) % A;
			}
			
			for (int i=0; i<round+1; i++) {
				daegiCnt++;
				if (type == 1 && daegiCnt == T) break loop;
				man = (man + 1) % A;
			}
			round++;
		}
		System.out.println(man);
		br.close();
	}

}
