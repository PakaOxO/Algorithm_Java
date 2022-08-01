package level_03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 단순 2진 암호코드 (문제 이상, 패스..)
public class SWEA_1240 {
//	public static int bufferSize = 7;
//	public static int codeSize = 8;
//	
//	public static int getCodeNum(String str) {
//		if (str.equals("0111011")) return 7;
//		if (str.equals("0110001")) return 5;
//		if (str.equals("0001101")) return 0;
//		if (str.equals("0010011")) return 2;
//		if (str.equals("0111011")) return 7;
//		
//		return -1;
//	}
//	
//	public static int isValidCode(List<Integer> list) {
//		int result = 0;
//		int testResult = 0;
//		System.out.println(list);
//		for (int j=0; j<codeSize-1; j++) {
//			result += list.get(j);
//			if (j % 2 == 0) {
//				testResult += list.get(j) * 3;
//			} else {
//				testResult += list.get(j);
//			}
//		}
//		if ((testResult + list.get(codeSize - 1)) % 10 == 0) return result + list.get(codeSize - 1);
//		return 0;
//	}
//
//	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int T= Integer.parseInt(br.readLine());
//		for (int i=1; i<=T; i++) {
//			StringTokenizer st = new StringTokenizer(br.readLine());
//			int N = Integer.parseInt(st.nextToken());
//			int M = Integer.parseInt(st.nextToken());
//			List<Integer> code = new ArrayList<>();
//			for (int j=0; j<N; j++) {
//				String codeLine = br.readLine();
//				if (codeLine.indexOf("1") == -1) continue;
//				String str = "";
//				for (int k=0; k<M; k++) {
//					str += codeLine.charAt(k);
//					if ((k + 1) % bufferSize == 0) {
//						if (Integer.parseInt(str, 2) != 0) {							
//							int codeNum = getCodeNum(str);
//							code.add(codeNum);
//							if (code.size() == codeSize) break;
//						}
//						str = "";
//					}
//				}
//				if (code.size() == codeSize) break;
//			}
//			int result = isValidCode(code);
//			System.out.println(result);
//		}
//	}

}
