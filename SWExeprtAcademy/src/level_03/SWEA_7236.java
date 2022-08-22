package level_03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 저수지의 물의 총 깊이 구하기 (User Problem)
public class SWEA_7236 {
	static int N;
	static char[][] res;
	static int[][] depth;
	static int maxDepth;
	
	static void getDepth() {
		int[][] drc = { {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1} };
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				if (res[i][j] == 'G') {
					depth[i][j] = 0;
					continue;
				}
				int cnt = 0;
				for (int k=0; k<drc.length; k++) {
					int r = i + drc[k][0];
					int c = j + drc[k][1];
					if (r < 0 || r >= N || c < 0 || c >= N) continue;
					if (res[r][c] == 'W') cnt++;
				}
				if (cnt == 0) cnt++;
				depth[i][j] = cnt;
				if (cnt > maxDepth) maxDepth = cnt;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			res = new char[N][N];
			for (int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j=0; j<N; j++) {
					res[i][j] = st.nextToken().charAt(0);
				}
			}
			maxDepth = 0;
			depth = new int[N][N];
			getDepth();
			sb.append("#").append(tc).append(" ").append(maxDepth).append("\n");
		}
		System.out.print(sb);
		br.close();
	}

}
