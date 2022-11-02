package graph;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_1043, 거짓말
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. 일단 파티에 진실을 아는 사람이 1명이라도 있으면 해당 파티에선 모두 진실만을 말해야하며 파티 참석 인원들도 모두 진실을 알게 됨
 *  2. 파티에 참석하는 사람의 번호로 구성된 2차원 배열을 만들어 관리
 *  3. 진실을 아는 사람부터 시작하는 BFS를 돌면서 진실을 아는 사람이 참석하는 모든 파티를 순회 -> 각 파티에 참석하는 사람을 큐에 담아 다시 BFS
 *      3.1 BFS의 결과로 진실을 아는 모든 사람과 해당 인원들이 참석하는 파티를 체크할 수 있음
 *      3.2 새로운 파티가 보일 때마다 answer - 1을 해 거짓을 말할 수 있는 파티의 수를 줄여줌
 *      3.3 만약 이전 BFS에서 방문했던 파티였으면 answer 값 수정 X
 *
 */
public class BaekJoon_1043 {
    static int N, M, answer;
    static List<Integer> list;
    static boolean[][] pMember;
    static boolean[] mVisited, pVisited;
    
    static void bfs(int pNo) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(pNo);
        mVisited[pNo] = true;
        
        while (!q.isEmpty()) {
            int curr = q.poll();
            
            for (int i=0; i<M; i++) {
                if (!pMember[i][curr]) continue;
                if (!pVisited[i]) {
                    answer--;
                    pVisited[i] = true;
                }
                
                for (int j=1; j<=N; j++) {
                    if (!pMember[i][j] || mVisited[j]) continue;
                    
                    mVisited[j] = true;
                    q.offer(j);
                }
            }
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        int pCnt = Integer.parseInt(st.nextToken());
        for (int i=0; i<pCnt; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        
        pMember = new boolean[M][N + 1];
        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            pCnt = Integer.parseInt(st.nextToken());
            for (int j=0; j<pCnt; j++) {
                int mNo = Integer.parseInt(st.nextToken());
                pMember[i][mNo] = true;
            }
        }
        br.close();
        
        mVisited = new boolean[N + 1];
        pVisited = new boolean[M];
        answer = M;
        for (int p : list) {
            if (mVisited[p]) continue;
            bfs(p);
        }
        
        System.out.println(answer);
    }

}
