package level_03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 힙
public class SWEA_2930 {
	
	static class Heap {
		int size;
		int[] heap;
		
		Heap() {
			this.size = 0;
			this.heap = new int[2000001];
		}
		
		void swap(int i, int j) {
			if (i == j) return;
			int temp = this.heap[i];
			this.heap[i] = this.heap[j];
			this.heap[j] = temp;
		}
		
		void add(int data) {
			this.heap[++this.size] = data;
			if (size == 1) return;
			
			int idx = size;
			while (idx > 1) {
				int pData = heap[idx / 2];
				if (data > pData) {
					swap(idx, idx/2);
					idx /= 2;
					continue;
				}
				break;
			}
		}
		
		int getMax() {
			if (size == 0) return -1;
			
			int max = heap[1];
			swap(1, size);
			heap[size--] = 0; 
			int idx = 1;
			while (true) {
				int left = idx * 2;
				int right = idx * 2 + 1;
				if (heap[idx] >= heap[left] && heap[idx] >= heap[right]) break;
				if (heap[left] > heap[right]) {
					swap(idx, left);
					idx = left;
				} else {
					swap(idx, right);
					idx = right;
				}
			}
			
			return max;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc=1; tc<=T; tc++) {
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");
			int N = Integer.parseInt(br.readLine());
			Heap h = new Heap();
			for (int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int type = Integer.parseInt(st.nextToken());
				if (type == 1) {
					int data = Integer.parseInt(st.nextToken());
					h.add(data);
				} else {
					sb.append(h.getMax()).append(" ");
				}
			}
			answer.append(sb.toString().trim()).append("\n");
		}
		System.out.print(answer);
		br.close();
	}

}
