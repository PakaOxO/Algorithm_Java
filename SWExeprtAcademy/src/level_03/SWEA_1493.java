package level_03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 수의 새로운 연산
public class SWEA_1493 {
	static int[] start;
	static int N = 300;
	
	static int binarySearch(int target) {
		int left = 1;
		int right = 149;
		int mid = 0;
		while (left <= right) {
			if (left == right) return left;
			mid = (left + right) / 2;
			if (target < start[mid]) {
				right = mid - 1;
			} else {
				if (target == start[mid]) return mid;
				left = mid + 1;
			}
		}
		return mid;
	}
	
	static int convertToXY(int num1, int num2) {
		int idx = binarySearch(num1);
		int x1 = 1 + (num1 - start[idx]);
		int y1 = idx - (num1 - start[idx]);
		
		idx = binarySearch(num2);
		int x2 = 1 + (num2 - start[idx]);
		int y2 = idx - (num2 - start[idx]);
		
		int x3 = x1 + x2;
		int y3 = y1 + y2;
		return start[x3 + y3 - 1] + x3 - 1;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		start = new int[N];
		start[1] = 1;
		for (int i=2; i<N; i++) {
			start[i] = start[i-1] + i - 1;
		}
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			int answer = convertToXY(p, q);
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
		br.close();
	}

}
