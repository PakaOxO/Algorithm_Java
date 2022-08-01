package loop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// X보다 작은 수
public class BaekJoon_10871 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<N; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (num < X) sb.append(num + " ");
		}
		System.out.println(sb.toString().trim());
		br.close();
	}

}
