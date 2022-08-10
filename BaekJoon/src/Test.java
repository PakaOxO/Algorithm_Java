import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] moveBook = new int[N]; // 입력 배열
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			moveBook[i] = Integer.parseInt(st.nextToken());
		}
		br.close();
		
		int capacity = M; // 용량
		int boxCount = 1; // 처음 시작 상자 개수
		for(int i = 0; i < N; i++) {
			if(capacity - moveBook[i] < 0) { // i번째 책의 무게가 남은 용량보다 크다면 박스를 증가시키고 용량을 초기화한다.
				capacity = M;
				boxCount++;
			}
			capacity -= moveBook[i]; // i번째 책을  넣는다.
		}
		if(N == 0) boxCount = 0; // N이 0일때는 0으로 바꿔준다.
		System.out.println(boxCount);
	}

}
