package sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//알고리즘 수업 - 선택 정렬 5
public class BaekJoon_23899 {
	static int N;
	static int[] arr1;
	static int[] arr2;
	static boolean isSame;
	
	static boolean compareArr() {
		boolean flag = true;
		for (int i=0; i<N; i++) {
			if (arr1[i] != arr2[i]) {
				flag = false;
				break;
			}
		}
		return flag;
	}
	
	static void swap(int i, int j) {
		int temp = arr1[i];
		arr1[i] = arr1[j];
		arr1[j] = temp;
	}
	
	static void selectionSort() {
		if (compareArr()) {
			isSame = true;
			return;
		}
		
		for (int i=N-1; i>0; i--) {
			
			int maxIdx = i;
			for (int j=i; j>=0; j--) {
				if (arr1[j] > arr1[maxIdx]) maxIdx = j;
			}
			if (maxIdx != i) {
				swap(i, maxIdx);
				if (compareArr()) {
					isSame = true;
					break;
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr1 = new int[N];
		for (int i=0; i<N; i++) {
			arr1[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		arr2 = new int[N];
		for (int i=0; i<N; i++) {
			arr2[i] = Integer.parseInt(st.nextToken());
		}
		selectionSort();
		if (isSame) System.out.println(1);
		else System.out.println(0);
		br.close();
	}

}
