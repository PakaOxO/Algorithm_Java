import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 신문 헤드라인
public class SWEA_2047 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String headline = br.readLine();
		
		System.out.println(headline.toUpperCase());
	}

}
