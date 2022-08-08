import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// 가장 큰 금민수 다시 풀기
public class Test {
	static String str;
	static StringBuilder sb = new StringBuilder();
	static boolean isGetNumber = false;
	static List<Integer> list = new ArrayList<>();
	
	static void getNumberList(int N) {
		if (N > str.length()) return;
		if (sb.length() > 0) {
			if (Integer.parseInt(sb.toString()) <= Integer.parseInt(str)) {
				list.add(Integer.parseInt(sb.toString()));
			}
		}
		
		sb.append("7");
		getNumberList(N + 1);
		sb.deleteCharAt(N);
		
		sb.append("4");
		getNumberList(N + 1);
		sb.deleteCharAt(N);
	}
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str = br.readLine();
		getNumberList(0);
		int answer = 0;
		for (int i=0; i<list.size(); i++) {
			if (list.get(i) > answer) answer = list.get(i);
		}
		System.out.println(answer);
		br.close();
	}

}
