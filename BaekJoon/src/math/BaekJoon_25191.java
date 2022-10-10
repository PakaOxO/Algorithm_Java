package math;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_25191, 치킨 댄스
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 
 *
 */
public class BaekJoon_25191 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		br.close();
		
		int answer = 0;
		while (N > 0) {
			if (B > 0) {
				if (B <= N) {
					answer += B;
					N -= B;
					B = 0;
				} else {
					answer += N;
					B -= N;
					N = 0;
				}
				continue;
			} else if (A > 0) {
				if (A / 2 <= N) {
					answer += A / 2;
					N -= A / 2;
					A -= A / 2;
				} else {
					answer += N;
					A -= N * 2;
					N = 0;
				}
			}
			break;
		}
		System.out.println(answer);
	}

}
