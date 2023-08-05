/**
 * BaekJoon_1926, 그림
 *  1. 문제 분류: 그래프, bfs, dfs
 *  2. 접근 방법
 *      - 주어진 영역 전체를 순회하면서 그림을 만나면 dfs로 방문하면서 방문 처리
 *      - 마주친 그림의 영역을 리턴
 *      - 모든 그림 중 그림의 영역이 가장 넓은 친구 리턴
 */
const solution = () => {
    /* 변수 초기화  */
    const input = require("fs").readFileSync("./dev/stdin/1926.txt").toString().split("\n");
    const [N, M] = input[0].split(" ").map((item) => +item);
    const board = [];
    const drc = [[0, 1], [1, 0], [-1, 0], [0, -1]];
    const v = Array.from({ length: N }, () => Array.from({ length: M }, () => false));
    let answer = [0, 0];

    /* 메인 로직 */
    for (let i=1; i<=N; i++) {
        board.push(input[i].split(" ").map((item) => +item));
    }

    for (let i=0; i<N; i++) {
        for (let j=0; j<M; j++) {
            if (board[i][j] === 0 || v[i][j]) continue;
            v[i][j] = true;
            const size = dfs(i, j);
            answer[0]++;
            if (size > answer[1]) answer[1] = size;
        }
    }

    return answer.join("\n");

    /* 그림 탐색 */
    function dfs(r, c) {
        let sum = 1;
        for (let i=0; i<drc.length; i++) {
            const [nr, nc] = [r + drc[i][0], c + drc[i][1]];
            if (nr < 0 || nc < 0 || nr >= N || nc >= M || v[nr][nc] || board[nr][nc] === 0) continue;
            v[nr][nc] = true;
            sum += dfs(nr, nc);
        }
        return sum;
    }
}

console.log(solution());