//package search;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//// 장난감 경주
//public class BaekJoon_19592 {
//	static int X, Y;
//	static double min;
//	static int speed;
//	static int answer;
//	
//	static void binarySearch() {
//		int left = 0;
//		int right = Y;
//		if (X / (double)speed < min) {
//			answer = 0;
//			return;
//		} else if ((X - ((min - 1) * speed)) >= Y) {
//			answer = -1;
//			return;
//		}
//		while (left < right) {
//			int mid = (left + right) / 2;
//			double nTime = (X - mid) / (double)speed;
//			if (nTime < (min - 1)) return;
//			double bTime = mid / (double)Y;
//			if (bTime > 1) return;
//			answer = mid;
//			System.out.println(answer);
//			if (nTime + bTime >= min) {
//				left = mid + 1;
//			} else {
//				right = mid - 1;
//			}
//		}
//	}
//
//	public static void main(String[] args) throws Exception {
//		StringBuilder sb = new StringBuilder();
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int T = Integer.parseInt(br.readLine());
//		for (int i=0; i<T; i++) {
//			StringTokenizer st = new StringTokenizer(br.readLine());
//			int N = Integer.parseInt(st.nextToken());
//			X = Integer.parseInt(st.nextToken());
//			Y = Integer.parseInt(st.nextToken());
//			st = new StringTokenizer(br.readLine());
//			min = Integer.MAX_VALUE;
//			for (int j=0; j<N-1; j++) {
//				long s = Long.parseLong(st.nextToken());
//				double t = X / (double)s;
//				min = Math.min(t, min);
//			}
//			speed = Integer.parseInt(st.nextToken());
//			answer = Y;
//			binarySearch();
//			System.out.println(answer);
//		}
//		System.out.println(sb.toString().trim());
//		br.close();
//	}
//
//}
