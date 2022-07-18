import java.util.Scanner;

// N줄 덧셈
public class SWEA_2025 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		System.out.println(N * (N + 1) / 2);
		sc.close();
	}

}
