package level_03;

import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;

// 암호문 3
public class SWEA_1230 {
	static StringTokenizer st;
	static int[] strPassword;
	static int[] result;
	
	private static void savePassword() {
		strPassword = new int[result.length];
		for (int i=0; i<result.length; i++) {
			strPassword[i] = result[i];
		}
	}
	
	private static void insert(int x, int y) {
		result = new int[strPassword.length + y];
		for (int i=0; i<x; i++) {
			result[i] = strPassword[i];
		}
		for (int i=0; i<y; i++) {
			int num = Integer.parseInt(st.nextToken());
			result[x+i] = num;
		}
		for (int i=0; i<strPassword.length - x; i++) {
			result[i+x+y] = strPassword[i+x];
		}
	}
	
	private static void delete(int x, int y) {
		result = new int[strPassword.length - y];
		for (int i=0; i<x; i++) {
			result[i] = strPassword[i];
		}
		for (int i=0; i<result.length - x; i++) {
			result[i+x] = strPassword[i+x+y];
		}
	}
	
	private static void add(int y) {
		result = new int[strPassword.length + y];
		for (int i=0; i<result.length; i++) {
			if (i < strPassword.length) result[i] = strPassword[i];
			else {
				result[i] = Integer.parseInt(st.nextToken());
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;
		for (int i=1; i<=T; i++) {
			int N = Integer.parseInt(br.readLine());
			strPassword = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				strPassword[j] = Integer.parseInt(st.nextToken());
			}
			
			int M = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<M; j++) {
				String order = st.nextToken();
				if (order.equals("I")) {
					int x = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());
					insert(x, y);
					savePassword();
				} else if (order.equals("D")) {
					int x = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());
					delete(x, y);
					savePassword();
				} else if (order.equals("A")) {
					int y = Integer.parseInt(st.nextToken());
					add(y);
					savePassword();
				} else {
					System.out.println("잘못된 명령문입니다.");
				}
			}
			String answer = "";
			for (int j=0; j<10; j++) {
				answer += (result[j] + " ");
			}
			System.out.printf("#%d %s\n", i, answer);
		}
		br.close();
	}

}
