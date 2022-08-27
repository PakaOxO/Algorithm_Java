package heap;

import java.util.*;
import java.io.*;

// 문제 추천 시스템 version 2 
public class BaekJoon_21944 {
	
	static class Problem implements Comparable<Problem> {
		int pNo;
		int level;
		int type;
		
		Problem(int pNo, int level, int type) {
			this.pNo = pNo;
			this.level = level;
			this.type = type;
		}
		
		@Override
		public int compareTo(Problem o) {
			if (this.level == o.level) {
				return this.pNo - o.pNo;
			}
			return this.level - o.level;
		}
		
		@Override
		public boolean equals(Object o) {
			if (o == null) return false;
			Problem p = (Problem)o;
			if (this.pNo == p.pNo) return true;
			return false;
		}
	}
	
	static TreeSet<Problem> treeSet = new TreeSet<Problem>();
	static TreeSet<Problem>[] subTreeSet = new TreeSet[101];
	static Map<Integer, int[]> hMap = new HashMap<>();
			
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int i=1; i<101; i++) {
			subTreeSet[i] = new TreeSet<>();
		}
		
		/* 트리에 문제 추가 */
		int N = Integer.parseInt(br.readLine());
		for (int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int pNo = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			int G = Integer.parseInt(st.nextToken());
			Problem p = new Problem(pNo, L, G);
			
			treeSet.add(p);
			subTreeSet[G].add(p);
			hMap.put(pNo, new int[] { L, G });
		}
		
		/* 명령어 실행 */
		int M = Integer.parseInt(br.readLine());
		for (int i=0; i<M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String order = st.nextToken();
			
			if (order.equals("add")) {
				int P = Integer.parseInt(st.nextToken());
				int L = Integer.parseInt(st.nextToken());
				int G = Integer.parseInt(st.nextToken());
				Problem p = new Problem(P, L, G);
				treeSet.add(p);
				subTreeSet[G].add(p);
				hMap.put(P, new int[] { L, G });
				continue;
			}
			
			if (order.equals("recommend")) {
				int G = Integer.parseInt(st.nextToken());
				int type = Integer.parseInt(st.nextToken());
				if (type == 1) sb.append(subTreeSet[G].last().pNo).append("\n");
				else sb.append(subTreeSet[G].first().pNo).append("\n");
				continue;
			}
			
			if (order.equals("recommend2")) {
				int type = Integer.parseInt(st.nextToken());
				if (type == 1) sb.append(treeSet.last().pNo).append("\n");
				else sb.append(treeSet.first().pNo).append("\n");
				continue;
			}
			
			if (order.equals("recommend3")) {
				int type = Integer.parseInt(st.nextToken());
				int L = Integer.parseInt(st.nextToken());
				if (type == -1) {
					Problem p = treeSet.lower(new Problem(0, L, 0));
					if (p == null) sb.append("-1\n");
					else sb.append(p.pNo).append("\n");
				} else {
					Problem p = treeSet.ceiling(new Problem(0, L, 0));
					if (p == null) sb.append("-1\n");
					else sb.append(p.pNo).append("\n");
				}
				continue;
			}
			
			if (order.equals("solved")) {
				int P = Integer.parseInt(st.nextToken());
				int L = hMap.get(P)[0];
				int G = hMap.get(P)[1];
				treeSet.remove(new Problem(P, L, G));
				subTreeSet[G].remove(new Problem(P, L, G));
				continue;
			}
		}
		System.out.print(sb);
		br.close();
	}

}
