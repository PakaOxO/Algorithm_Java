package level_04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 중위순회
public class SWEA_1231 {
	static int N;
	static char[] tree;
	static StringBuilder sb;

	static void inOrder(int idx) {
		
		if (idx*2 <= N && tree[idx*2] != 0) inOrder(idx * 2);
		sb.append(tree[idx]);
		if (idx*2+1 <= N && tree[idx*2+1] != 0) inOrder(idx*2+1);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		for (int tc=1; tc<=10; tc++) {
			N = Integer.parseInt(br.readLine());
			tree = new char[N + 1];
			sb.append("#").append(tc).append(" ");
			for (int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int nodeNo = Integer.parseInt(st.nextToken());
				char data = st.nextToken().charAt(0);
				tree[nodeNo] = data;
			}
			inOrder(1);
			sb.append("\n");
		}
		System.out.print(sb);
		br.close();
	}

}
