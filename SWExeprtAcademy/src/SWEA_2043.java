import java.util.Scanner;

// 서랍의 비밀번호 
public class SWEA_2043 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int P = sc.nextInt();
		int K = sc.nextInt();
		System.out.println(P - K + 1);
		sc.close();
	}

}
