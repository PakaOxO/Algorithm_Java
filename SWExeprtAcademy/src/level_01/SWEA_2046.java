package level_01;
import java.util.Arrays;
import java.util.Scanner;

// 스탬프 찍기
public class SWEA_2046 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String[] arr = new String[N];
		Arrays.fill(arr, "#");
		System.out.println(String.join("", arr));
		sc.close();
	}

}
