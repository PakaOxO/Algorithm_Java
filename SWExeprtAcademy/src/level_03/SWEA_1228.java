package level_03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 암호문 1
public class SWEA_1228 {
	public static StringTokenizer st;
	public static List<Integer> codeList;
	public static void insert(int pos, int cnt) {
		for (int i=0; i<cnt; i++) {
			codeList.add(pos++, Integer.parseInt(st.nextToken()));
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		int T = 10;
		for (int i=1; i<=T; i++) {
			int N = Integer.parseInt(br.readLine());
			codeList = new ArrayList<Integer>();
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				codeList.add(Integer.parseInt(st.nextToken()));
			}
			
			int M = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<M; j++) {
				String type = st.nextToken();
				if (type.equals("I")) insert(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			
			answer.append("#" + i + " ");
			for (int j=0; j<10; j++) {
				answer.append(codeList.get(j) + " ");
			}
			answer.append("\n");
		}
		System.out.println(answer.toString().trim());
		br.close();
	}
}
