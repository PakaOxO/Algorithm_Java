package level_03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 직사각형 길이 찾기
public class SWEA_3456 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int i=1; i<=T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] arr = new int[3];
			int idx = 0;
			while (idx < 3) {
				arr[idx++] = Integer.parseInt(st.nextToken());
			}
			
			int result = (arr[0] == arr[1]) ? arr[2] : ((arr[0] == arr[2]) ? arr[1] : arr[0]);
			sb.append("#" + i + " " + result + "\n");
		}
		System.out.println(sb.toString().trim());
		br.close();
	}

}
