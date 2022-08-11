package search;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// ¼±¹°
public class BaekJoon_1166 {
	static double N, L, W, H;
	static double answer;
	
	static void binarySearch(double max) {
		double left = 0;
		double right = max;
		int loopCnt = 0;
		while (left <= right) {
			if (loopCnt > 100000) break;
			double mid = ((left + right) / 2);
			double cnt = Math.floor(L / mid) * Math.floor(W / mid) * Math.floor(H / mid);
			if (cnt >= N) {
				answer = mid;
				left = mid;
			} else {
				right = mid;
			}
			loopCnt++;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Double.parseDouble(st.nextToken());
		L = Double.parseDouble(st.nextToken());
		W = Double.parseDouble(st.nextToken());
		H = Double.parseDouble(st.nextToken());
		
		double min = (L > W) ? W : L;
		min = (min > H) ? H : min;
		binarySearch(min);
		System.out.println(answer);
	}

}
