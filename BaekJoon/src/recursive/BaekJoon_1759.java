package recursive;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_1759, 암호 만들기
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 모음은 최소 1개 이상, 자음은 최소 2개 이상 포함되어야 함.
 * 	2. 모음을 1개부터 받은 모음의 개수까지 뽑되 L - (뽑을 모음의 개수)가 2보다 작아지면 안됨(자음은 최소 2개 이상 뽑아야함)
 * 	2. 모음을 뽑고 남은 개수만큼 자음을 뽑고, 뽑은 모든 글자들을 정렬한 뒤 만들 수 있는 암호 목록 리스트에 add
 * 	3. 암호 목록을 다시 한번 정렬한 뒤 순서대로 출력
 *
 */
public class BaekJoon_1759 {
	static int L, C;
	static char[] password, letter;
	static List<Character> moeum, jaeum;
	static boolean[] moeumUsed, jaeumUsed;
	static List<String> answer;
	
	static void getMoeum(int start, int depth, int maxDepth) {
		if (depth == maxDepth) {
			jaeumUsed = new boolean[jaeum.size()];
			getJaeum(0, depth);
			return;
		}
		
		for (int i=start; i<moeum.size(); i++) {
			if (moeumUsed[i]) continue;
			
			password[depth] = moeum.get(i);
			moeumUsed[i] = true;
			getMoeum(i + 1, depth + 1, maxDepth);
			moeumUsed[i] = false;
		}
	}
	
	static void getJaeum(int start, int depth) {
		if (depth == L) {
			char[] copied = password.clone();
			Arrays.sort(copied);
			answer.add(new String(copied));
			return;
		}
		
		for (int i=start; i<jaeum.size(); i++) {
			if (jaeumUsed[i]) continue;
			password[depth] = jaeum.get(i);
			jaeumUsed[i] = true;
			getJaeum(i + 1, depth + 1);
			jaeumUsed[i] = false;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		password = new char[L];
		letter = new char[C];
		
		moeum = new ArrayList<>();
		jaeum = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<C; i++) {
			char l = st.nextToken().charAt(0);
			letter[i] = l;
			
			if (l == 'a' || l == 'e' || l == 'i' || l == 'o' || l == 'u') moeum.add(l);
			else jaeum.add(l);
		}
		br.close();
		
		answer = new ArrayList<>();
		for (int i=1; i<=moeum.size(); i++) {
			if (L - i < 2) break;
			
			moeumUsed = new boolean[moeum.size()];
			getMoeum(0, 0, i);
		}
		Collections.sort(answer);
		
		StringBuilder sb = new StringBuilder();
		for (String p : answer) {
			sb.append(p).append("\n");
		}
		System.out.print(sb);
	}

}
