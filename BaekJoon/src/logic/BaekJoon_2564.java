package logic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 경비원
public class BaekJoon_2564 {
	static int W, H;
	static int[][] points;
	
	static int findDistance(int mDir, int mPos, int tDir, int tPos) {
		
		if (tDir == mDir) {
			return Math.abs(mPos - tPos); // 같은 변에 있을 때
		} else {
			if (mDir == 1 || mDir == 2) {
				if (tDir == 1 || tDir == 2) {
					return Math.min(mPos + tPos + H, 2 * W - mPos - tPos + H); // min((1, 2), (2, 1))
				} else {
					if (tDir == 3) {
						return (mDir == 1) ? mPos + tPos : mPos + (H - tPos); // (1, 3), (2, 3)
					} else {
						return (mDir == 1) ? (W - mPos) + tPos : (W - mPos) + (H - tPos); // (1, 4), (2, 4)
					}
				}
			} else {
				if (tDir == 3 || tDir == 4) {
					return Math.min(mPos + tPos + W, 2 * H - mPos - tPos + W); // min((3, 4), (4, 3))
				} else {
					if (tDir == 1) {
						return (mDir == 3) ? mPos + tPos : mPos + (W - tPos); // (3, 1), (4, 1)
					} else {
						return (mDir == 3) ? (H - mPos) + tPos : (H - mPos) + (W - tPos); // (3, 2), (4, 2)
					}
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(br.readLine());
		points = new int[N][2];
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			points[i][0] = Integer.parseInt(st.nextToken());
			points[i][1] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int direction = Integer.parseInt(st.nextToken());
		int pos = Integer.parseInt(st.nextToken());
		
		int sum = 0;
		for (int i=0; i<N; i++) {
			sum += findDistance(direction, pos, points[i][0], points[i][1]);
		}
		System.out.println(sum);
		br.close();
	}

}
