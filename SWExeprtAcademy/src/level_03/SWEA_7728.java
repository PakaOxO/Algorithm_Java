package level_03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

// 다양성 측정
public class SWEA_7728 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i=1; i<=T; i++) {
			char[] arr = br.readLine().toCharArray();
			Set<Integer> set = new HashSet<>();
			for (char c:arr) {
				int num = (int)c - 48;
				if (!set.contains(num)) set.add(num);
			}
			System.out.printf("#%d %d\n", i, set.size());
		}
		br.close();
	}
}
