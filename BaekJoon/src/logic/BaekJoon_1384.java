package logic;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 메시지
public class BaekJoon_1384 {
	public static String[][] messages;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		String line;
		int groupNo = 0;
		while (!(line = br.readLine()).equals("0")) {
			StringBuilder sb = new StringBuilder();
			int N = Integer.parseInt(line);
			messages = new String[N][];
			for (int i=0; i<N; i++) {
				messages[i] = br.readLine().split(" ");
			}
			for (int i=0; i<N; i++) {
				for (int j=1; j<N; j++) {
					if (messages[i][j].equals("N")) {
						sb.append(messages[(i - j + N) % N][0] + " was nasty about " + messages[i][0] + "\n");
					}
				}
			}
			if (sb.length() == 0) sb.append("Nobody was nasty" + "\n");
			answer.append("Group " + (++groupNo) + "\n" + sb + "\n");
		}
		System.out.println(answer.toString().trim());
		br.close();
	}

}
