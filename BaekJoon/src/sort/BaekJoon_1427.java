package sort;

import java.io.*;
import java.util.*;

// 소트인사이드
public class BaekJoon_1427 {
	static Character[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int len = input.length();
		arr = new Character[len];
		for (int i=0; i<len; i++) {
			arr[i] = input.charAt(i);
		}
		
		Arrays.sort(arr, new Comparator<Character>() {
			@Override
			public int compare(Character o1, Character o2) {
				return o2 - o1;
			}
		});
		
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<len; i++) {
			sb.append(arr[i]);
		}
		System.out.println(sb);
		br.close();
	}

}
