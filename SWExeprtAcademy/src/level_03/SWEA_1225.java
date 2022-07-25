package level_03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 암호 생성기
public class SWEA_1225 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str;
		while ((str = br.readLine()) != null) {
			int t = Integer.parseInt(str);
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] arr = new int[8];
			for (int i=0; i<8; i++) {
				arr[i] = Integer.parseInt(st.nextToken());		
			}
			
			int idx = 0;
			int reducer = 1;
			while (true) {
				arr[idx] -= reducer;
				if (arr[idx] <= 0) {
					arr[idx] = 0;
					break;
				}
				idx = (idx + 1) % 8;
				if (reducer + 1 > 5) {
					reducer = 1;
				} else {
					reducer++;
				}
			}
			
			String result = "";
			int i = idx + 1;
			while (true) {
				if (i == 8) i = 0;
				result += arr[i] + " ";
				if (i == idx) break;
				i++;
			}
			System.out.printf("#%d %s\n", t, result);
		}
	}

}
