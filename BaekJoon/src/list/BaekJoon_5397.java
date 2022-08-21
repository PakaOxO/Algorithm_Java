package list;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class BaekJoon_5397 {
	static List<Character> list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc=1; tc<=T; tc++) {
			String str = br.readLine();
			list = new LinkedList<>();
			int pointer = -1;
			for (int i=0; i<str.length(); i++) {
				char c = str.charAt(i);
				if (c == '<') {
					if (pointer == -1) continue;
					if (i + 1 <= str.length() - 1 && str.charAt(i + 1) == '>') {
						i++;
						continue;
					}
					pointer--;
					continue;
				}
				
				if (c == '>') {
					if (pointer == list.size() - 1) continue;
					if (i + 1 <= str.length() - 1 && str.charAt(i + 1) == '<') {
						i++;
						continue;
					}
					pointer++;
					continue;
				}
				
				if (c == '-') {
					if (pointer == -1 || list.size() == 0) continue;
					list.remove(pointer--);
					continue;
				}
				
				if (i + 1 <= str.length() - 1 && str.charAt(i + 1) == '-') {
					i++;
					continue;
				}
				list.add(++pointer, c);
			}
			
			ListIterator<Character> li = list.listIterator();
			while (li.hasNext()) {
				sb.append(li.next());
			}
			sb.append("\n");
		}
		System.out.print(sb);
		br.close();
	}

}
