package dfs;

import java.io.*;

public class BaekJoon_2661 {
	static int N;
	static char[] list = { '1', '2', '3' };
	static char[] comb;
	
	static boolean checkIsBad(char c, int cnt) {
		comb[cnt] = c;
		int i = 1;
		boolean isBad = false;
		while (i <= (cnt + 1) / 2) {
			int j = 0;
			boolean isSame = true;
			while (j < i) {
				if (comb[cnt - j] != comb[cnt - j - i]) {
					isSame = false;
					break;
				}
				j++;
			}
			if (isSame) {
				isBad = true;
				break;
			}
			i++;
		}
		if (isBad) return true;
		return false;
	}
	
	static void dfs(int cnt) {
		if (cnt == N) {
			System.out.println(comb);
			System.exit(0);
		}
		
		for (int i=0; i<3; i++) {
			if (checkIsBad(list[i], cnt)) continue;
			comb[cnt] = list[i];
			dfs(cnt + 1);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		br.close();
		
		comb = new char[N];
		dfs(0);
	}

}
