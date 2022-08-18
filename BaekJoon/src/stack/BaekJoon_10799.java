package stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// ¼è¸·´ë±â
public class BaekJoon_10799 {
	static Stack<Integer> pos = new Stack<>();
	static Stack<Character> stack = new Stack<>();
	static List<Integer> lazer = new ArrayList<>();
	static List<Integer> lods = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int len = input.length();
		for (int i=0; i<len; i++) {
			if (stack.size() == 0) {
				stack.push(input.charAt(i));
				pos.push(i);
				continue;
			}
			char c = input.charAt(i);
			if (c != ')') {
				stack.push(c);
				pos.push(i);
				continue;
			}
			stack.pop();
			int from = pos.pop();
			if (i - from == 1) lazer.add(i);
			else {
				lods.add(from);
				lods.add(i);
			}
		}
		int answer = 0;
		for (int i=0; i<lods.size(); i+=2) {
			answer++;
			for (int j=0; j<lazer.size(); j++) {
				int point = lazer.get(j);
				if (point > lods.get(i) && point < lods.get(i+1)) {
					answer++;
				}	
			}
		}
		System.out.println(answer);
		br.close();
	}

}
