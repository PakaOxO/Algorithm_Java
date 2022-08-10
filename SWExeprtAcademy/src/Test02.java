	
import java.util.Scanner;
public class Test02 { // SW expert
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        for (int tc = 1; tc <= 10; tc++) {
            int[] arr = new int[101]; // 0 은 기본값0으로 무시 , 1~100까지 높이에 해당하는 수 카운트 배열 
            int temp = sc.nextInt();
            for (int i = 1; i <= 100; i++) { // 케이스 높이의 개수 카운트 
                arr[sc.nextInt()]++;
            }

            int cnt = temp;
            int i = 100; // 숫자 100에 해당 하는 인덱스 부터 내려오기 
            int j = 1;  // 숫자 1에 해당 하는 인덱스부터 올라가기 

            // 제일 큰 값을 1씩 뺴줘서 제일 작은 값에 1씩 더해주는 방식 
            while (cnt!=0) {
                if (arr[i] > 0) { // i번에 해당 하는 숫자의 카운트가 0보다 크면
                    arr[i]--; // 1개를 빼주고 
                    arr[i - 1]++; // i-1번의 카운트를 늘려주고 
                    cnt--; // 카운트를 1 빼준다 
                    if (arr[j] > 0) { //j번에 해당하는 숫자의 카운트가 0보다 크면 
                        arr[j]--; //1개를 빼주고 
                        arr[j + 1]++; // j+1의 카운트를 늘려준다 .

                    }else { // i의 카운트를 빼줬지만 j는 실행 못했으므로 j+1번째의 카운트를 1빼주기 
                        while(arr[j]==0) { // 최소값 찾아주기 
                            j++;
                        }
                        arr[j]--;
                        arr[j+1]++;
                    }
                }else { // i 카운트가 0보다 작으므로 1씩빼면서 카운트가 있는 i를 찾아주기 
                    i--;
                }
            }

            int result=i-j; // temp==cnt 가 다 소멸 됐으므로 그때의 가장 큰 값인 i와 가장 작은 값인 j를 빼줘서 답구하기 
            System.out.println("#" + tc +" "+ result);
        } // tc for문
    }// main
}