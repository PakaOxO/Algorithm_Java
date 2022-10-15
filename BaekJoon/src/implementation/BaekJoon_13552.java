package implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 구와 쿼리
public class BaekJoon_13552 {
	static StringTokenizer st;
	static long[][] points;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		points = new long[N][3];
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			points[i][0] = Long.parseLong(st.nextToken());
			points[i][1] = Long.parseLong(st.nextToken());
			points[i][2] = Long.parseLong(st.nextToken());
		}
		
		StringBuilder sb = new StringBuilder();
		int M = Integer.parseInt(br.readLine());
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			long x = Long.parseLong(st.nextToken());
			long y = Long.parseLong(st.nextToken());
			long z = Long.parseLong(st.nextToken());
			long r = Long.parseLong(st.nextToken());
			int cnt = 0;
			for (int j=0; j<N; j++) {
				long dx = x - points[j][0];
				long dy = y - points[j][1];
				long dz = z - points[j][2];
				double dist = Math.sqrt(dx*dx + dy*dy + dz*dz);
				if (dist <= r) cnt++;
			}
			sb.append(cnt).append("\n");
		}
		System.out.println(sb.toString().trim());
		br.close();
	}

}
