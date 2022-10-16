package backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BaekJoon_15651, N과 M (3)
 * @author kevin-Arpe
 * 
 * Sketch idea
 * 	1. 중복 선택을 허용하는 조합입니다.
 * 	2. 중복 선택을 허용하기 때문에 매 재귀함수(dfs) 호출 시마다 for(1 ~ N)문을 돌며 선택될 수 있는 모든 순열을 탐색합니다.
 * 	3. 이번 문제를 풀면서 Char array는 StrinBuilder에 바로 문자열로 삽입할 수 있음을 알았습니다.
 * 		3.1 조합될 문자열의 길이는 M * 2(문자 M개 + 공백 M-1개 + 개행 1개)이므로 해당 길이만큼의 배열을 생성합니다.
 * 		3.2 마지막 문자는 개행문자, 짝수 인덱스의 위치는 공백문자이므로 해당 위치에 값들을 미리 채워넣습니다
 * 		3.3 재귀함수에서는 인덱스 0부터 2의 배수만큼 증가하며 순열에 해당하는 값들을 채워 넣습니다. 값을 채워넣을 위치 인덱스를 가리키는 변수는 pos를 사용했습니다.
 * 
 */
public class BaekJoon_15651 {
	static int N, M;
	static boolean[] isVisited;
	static char[] arr;
	static StringBuilder sb;
	
	static void dfs(int pos) {
		if (pos == M) {
			sb.append(arr);
			return;
		}
		for (int i=1; i<=N; i++) {
			arr[pos * 2] = (char)(i + '0');
			dfs(pos + 1);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new char[M * 2];
		arr[M * 2 - 1] = '\n';
		for (int i=1; i<M*2-1; i+=2) {
			arr[i] = ' ';
		}
		
		sb = new StringBuilder();
		dfs(0);
		System.out.print(sb);
		br.close();
	}

}
