package bruteForce;

import java.io.*;
import java.util.StringTokenizer;

/**
 * BaekJoon_22864, 피로도
 * @author kevin-Arpe
 * 
 */
public class BaekJoon_22864 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int hour = 0;
		int workHour = 0;
		int g = 0;
		while (hour < 24) {
			if (A > M) break;
			if (g + A <= M) {
				workHour++;
				g += A;
				hour++;
			} else {
				g = (g - C < 0) ? 0 : g - C;
				hour++;
			}
		}
		System.out.println(workHour * B);
		br.close();
	}

}
