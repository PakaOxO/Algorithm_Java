package kakao2019_winter;

import java.util.*;

public class 튜플 {
	static int intMax = 1000001;
	static int listPointer;
	static List<List<Integer>> list = new ArrayList<>();
	static Stack<Character> stack = new Stack<>();
	static int[] cnt = new int[100001];
	
	static void makeTupleList(String s) {
		int num = 0;
		
		for (int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			
			if (c == '{') {
				if (!stack.isEmpty()) {
					if (stack.peek() == '{') {
						list.add(new ArrayList<>());
						listPointer++;
					}
				}
				stack.push(c);
				continue;
			} else if (c == '}') {
				if (num > 0) {
					list.get(listPointer).add(num);
				}
				stack.pop();
				num = 0;
			} else if (c == ',') {
				if (num > 0) {
					list.get(listPointer).add(num);
				}
				num = 0;
				continue;
			} else if (c >= '0' && c <= '9') {
				num = num * 10 + (int)(c - '0');
			}
		}
	}
	
	public int[] solution(String s) {
		// 처음 집합을 가리킬 포인터 (처음 집합 데이터를 가져오기 전 포인터는 -1) 
		listPointer = -1;
		makeTupleList(s);
		
		Collections.sort(list, new Comparator<List<Integer>>() {
			@Override
			public int compare(List<Integer> o1, List<Integer> o2) {
				return o1.size() - o2.size();
			}
		});
		
		int[] answer = new int[list.size()];
		int pointer = 0;
		for (List<Integer> l : list) {
			int[] count = new int[intMax];
			for (int num : l) {
				count[num]++;
				if (count[num] > cnt[num]) {
					cnt[num]++;
					answer[pointer++] = num;
				}
			}
		}
		
		return answer;
	}

}
