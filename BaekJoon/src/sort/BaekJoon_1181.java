package sort;

import java.io.*;
import java.util.*;

// 단어 정렬
public class BaekJoon_1181 {
	static String[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new String[N];
		for (int i=0; i<N ;i++) {
			arr[i] = br.readLine();
		}
		Arrays.sort(arr, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if (o1.length() == o2.length()) {
					return o1.compareTo(o2);
				}
				return o1.length() - o2.length();
			}
		});
		
		StringBuilder sb = new StringBuilder();
		String prev = null;
		for (int i=0; i<N; i++) {
			if (prev != null && arr[i].equals(prev)) continue;
			sb.append(arr[i]).append("\n");
			prev = arr[i];
		}
		System.out.print(sb);
		br.close();
	}

}
