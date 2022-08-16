package queue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// 기념품
public class BaekJoon_12873 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<>();
		for (int i=1; i<=N; i++) {
			list.add(i);
		}
		long i = 1;
		long idx = 0;
		while (list.size() > 1) {
			int next = (int)((i * i * i - 1 + idx) % list.size());
			list.remove(next);
			idx = next;
			i++;
		}
		System.out.println(list.remove(0));
		br.close();
	}

}
