package bruteForce;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_18808, 스티커 붙이기
 * @author kevin-Arpe
 *
 */
public class BaekJoon_18808 {
	static int N, M, K;
	static int[][][] stickers;

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
			for (int j=0; j<H; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k=0; k<W; k++) {
					stickers[i][j][k] = Integer.parseInt(st.nextToken());
				}
			}
		}
		
		
	}

}
