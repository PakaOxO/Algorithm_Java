package bruteForce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// DNA
public class BaekJoon_1969 {
	static int N, M;
	static String[] list;
	static char[] data = { 'A', 'C', 'G', 'T' };
	static int minDist;
	static String answer;
	
	static void getDNA(String dna, int len) {
		if (len == M) {
			int dist = getDistance(dna, M);
			if (dist < minDist) {
				minDist = dist;
				answer = dna;
			}
			return;
		}
		for (int i=0; i<data.length; i++) {
			getDNA(dna + data[i], len + 1);
		}
	}
	
	static int getDistance(String target, int len) {
		int cnt = 0;
		for (int i=0; i<N; i++) {
			for (int j = 0; j<len; j++) {
				if (list[i].charAt(j) != target.charAt(j)) cnt++;
			}
		}
		return cnt;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new String[N];
		for (int i=0; i<N; i++) {
			list[i] = br.readLine();
		}
		
		minDist = Integer.MAX_VALUE;
		getDNA("", 0);
        StringBuilder sb = new StringBuilder();
        sb.append(answer).append("\n").append(minDist);
		System.out.println(sb);
		br.close();
	}

}

