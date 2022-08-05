package string;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

// 팀 이름 정하기
public class BaekJoon_1296 {
	public static int[] cnt;
	public static int L;
	public static int O;
	public static int V;
	public static int E;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String yeonDu = br.readLine();
		cnt = new int[4];
		for (int i=0; i<yeonDu.length(); i++) {
			if (yeonDu.charAt(i) == 'L') cnt[0]++;
			else if (yeonDu.charAt(i) == 'O') cnt[1]++;
			else if (yeonDu.charAt(i) == 'V') cnt[2]++;
			else if (yeonDu.charAt(i) == 'E') cnt[3]++;
		}
		
		int N = Integer.parseInt(br.readLine());
		String answer = "";
		int max = Integer.MIN_VALUE;
		String[] names = new String[N];
		for (int i=0; i<N; i++) {
			String name = br.readLine();
			names[i] = name;
		}
		Arrays.sort(names);
		for (String name : names) {
			L = cnt[0];
			O = cnt[1];
			V = cnt[2];
			E = cnt[3];
			for (int j=0; j<name.length(); j++) {
				if (name.charAt(j) == 'L') L++;
				else if (name.charAt(j) == 'O') O++;
				else if (name.charAt(j) == 'V') V++;
				else if (name.charAt(j) == 'E') E++;
			}
			int result = (L + O) * (L + V) * (L + E) * (O + V) * (O + E) * (V + E) % 100;
			if (result > max) {
				max = result;
				answer = name;
			}
		}
		System.out.println(answer);
		br.close();
	}

}
