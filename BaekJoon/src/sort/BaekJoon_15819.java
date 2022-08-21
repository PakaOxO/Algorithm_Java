package sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 너의 핸들은
public class BaekJoon_15819 {
	static String[] words;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int I = Integer.parseInt(st.nextToken());
		words = new String[N];
		for (int i=0; i<N; i++) {
			words[i] = br.readLine();
		}
		Arrays.sort(words);
		System.out.println(words[I-1]);
		br.close();
	}

}
