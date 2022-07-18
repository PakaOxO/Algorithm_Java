package level_01;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 알파벳을 숫자로 변환 
public class SWEA_2050 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] charArr = br.readLine().toCharArray();
		String[] intArr = new String[charArr.length];
		for (int i=0; i<charArr.length; i++) {
			// getNumericValue : A -> 10으로 변환 (-9를 해서 1로 맞춰주기)
			intArr[i] = Integer.toString(Character.getNumericValue(charArr[i]) - 9);
		}
		System.out.println(String.join(" ", intArr));
	}

}
