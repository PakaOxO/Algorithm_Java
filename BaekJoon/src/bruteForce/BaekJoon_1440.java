package bruteForce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

// 타임머신
public class BaekJoon_1440 {
	static String[] time;
	static boolean[] isVisited;
	static List<String> list;
	
	static void timeCollection(String result, int cnt) {
		if (cnt == 3) {
			list.add(result);
			return;
		}
		for (int i=0; i<3; i++) {
			if (isVisited[i]) continue;
			isVisited[i] = true;
			StringBuilder sb = new StringBuilder();
			sb.append(result).append(time[i]);
			timeCollection(sb.toString(), cnt + 1);
			isVisited[i] = false;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), ":");
		time = new String[3];
		isVisited = new boolean[3];
		for (int i=0; i<3; i++) {
			time[i] = st.nextToken();
		}
		String result = "";
		list = new ArrayList<>();
		timeCollection(result, 0);
		Iterator<String> it = list.iterator();
		int cnt = 0;
		while (it.hasNext()) {
			String t = (String)it.next();
			int hour = Integer.parseInt(t.substring(0, 2));
			if (hour < 1 || hour > 12) continue;
			int minute = Integer.parseInt(t.substring(2, 4));
			if (minute < 0 || minute > 59) continue;
			int second = Integer.parseInt(t.substring(4, 6));
			if (second < 0 || second > 59) continue;
			cnt++;
		}
		System.out.println(cnt);
		br.close();
	}

}
