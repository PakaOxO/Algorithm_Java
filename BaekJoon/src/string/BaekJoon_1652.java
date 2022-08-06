package string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 누울 자리를 찾아라
public class BaekJoon_1652 {
	private static String[] room;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		room = new String[N];
		for (int i=0; i<N; i++) {
			room[i] = br.readLine();
		}
		int horzCnt = 0;
		int vertCnt = 0;
		for (int i=0; i<N; i++) {
			int horzVoid = 0;
			int vertVoid = 0;
			for (int j=0; j<N; j++) {
				if (room[i].charAt(j) == 'X') horzVoid = 0;
				else {
					if (++horzVoid == 2) horzCnt++;
				}
				if (room[j].charAt(i) == 'X') vertVoid = 0;
				else {
					if (++vertVoid == 2) vertCnt++;
				}
			}
		}
		System.out.println(horzCnt + " " + vertCnt);
	}

}
