package sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 잔디깎기
public class BaekJoon_3845 {
	static double[] nxs;
	static double[] nys;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		while (true) {
			st = new StringTokenizer(br.readLine());
			int nx = Integer.parseInt(st.nextToken()), ny = Integer.parseInt(st.nextToken());
			double w = Double.parseDouble(st.nextToken());
			if (nx == 0 && ny == 0) break;
			
			nxs = new double[nx];
			st = new StringTokenizer(br.readLine()); 
			for (int i=0; i<nx; i++) {
				nxs[i] = Double.parseDouble(st.nextToken());
			}
			Arrays.sort(nxs);
			
			boolean flag = true;
			if (nxs[0] > w/2) flag = false;
			if (nxs[nx-1] < 75 - (w/2)) flag = false;
			if (flag) {
				for (int i=0; i<nx-1; i++) {
					if (nxs[i+1] - nxs[i] > w) {
						flag = false;
						break;
					}
				}
			}
			nys = new double[ny];
			st = new StringTokenizer(br.readLine());
			for (int i=0; i<ny; i++) {
				nys[i] = Double.parseDouble(st.nextToken());
			}
			if (flag) {
				Arrays.sort(nys);
				if (nys[0] > w/2) flag = false;
				if (nys[ny-1] < 100 - (w/2)) flag = false;
				if (flag) {
					for (int i=0; i<ny-1; i++) {
						if (nys[i+1] - nys[i] > w) {
							flag = false;
							break;
						}
					}
				}
			}
			
			if (flag) sb.append("YES\n");
			else sb.append("NO\n");
		}
		System.out.print(sb);
		br.close();
	}

}
