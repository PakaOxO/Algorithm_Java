package stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * BaekJoon_1406, 에디터
 * @author kevin-Arpe
 *
 * Sketch Idea
 * 	1. 커서를 기준으로 좌측과 우측 문자열을 담을 스택 2개를 만들어 풀이
 * 	2. 명령어별 동작 방식
 * 		2.1 L : 커서를 왼쪽으로 -> lStack의 상단 요소를 pop하여 rStack에 push, 만약 lStack에 요소가 없었다면 무시
 * 		2.2 D : 커서를 오른쪽으로 -> rStack의 상단 요소를 pop하여 lStack에 push, 만약 rStack에 요소가 없었다면 무시
 * 		2.3 B : 커서 왼쪽 문자 삭제 -> lStack에 있는 상단 요소 pop, 만약 lStack에 요소가 없었다면 무시
 * 		2.4 P $ : $라는 문자를 커서 왼쪽에 추가 -> lStack에 문자 $를 push
 * 
 * 	3. 에디터 작업 종료 후 스택에 남은 문자들을 모두 합쳐 문자열로 변환
 * 		3.1 왼쪽 lStack의 경우 역순으로 pop되므로 reverse() 필요
 * 
 */
public class BaekJoon_1406 {
	static Stack<Character> rStack;
	static Stack<Character> lStack;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		lStack = new Stack<>();
		rStack = new Stack<>();
		
		String str = br.readLine();
		for (int i=0; i<str.length(); i++) {
			lStack.push(str.charAt(i));
		}
		
		int N = Integer.parseInt(br.readLine());
		for (int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char c = st.nextToken().charAt(0);
			if (c == 'L') {
				if (lStack.size() == 0) continue;
				rStack.push(lStack.pop());
				continue;
			}
			if (c == 'D') {
				if (rStack.size() == 0) continue;
				lStack.push(rStack.pop());
				continue;
			}
			if (c == 'B') {
				if (lStack.size() == 0) continue;
				lStack.pop();
				continue;
			}
			if (c == 'P') {
				char l = st.nextToken().charAt(0);
				lStack.push(l);
				continue;
			}
		}
		StringBuilder sb = new StringBuilder();
		while (lStack.size() > 0) {
			sb.append(lStack.pop());
		}
		sb.reverse();
		while (rStack.size() > 0) {
			sb.append(rStack.pop());
		}
		System.out.println(sb);
		br.close();
	}

}
