/**
 * Programmers_광고 삽입
 *  - 문제 분류: 누적 합, 슬라이딩 윈도우
 */
const solution = (play_time, adv_time, logs) => {
  /* 변수 초기화 */
  const [hTos, mTos] = [3600, 60];
  let endTime = 0;
  let w = 0;
  let acc = null;
  let [left, right] = [0, 0];
  const N = logs.length;
  let [total, max] = [0, 0];
  let answer = "";

  /* 메인 로직 */
  endTime = getSeconds(play_time);
  w = getSeconds(adv_time);
  acc = Array.from({ length: endTime + 1 }, () => 0);

  for (let i = 0; i < N; i++) {
    const [strStart, strEnd] = logs[i].split("-");
    const [start, end] = [getSeconds(strStart), getSeconds(strEnd)];
    acc[start]++;
    if (end <= endTime) {
      acc[end]--;
    }
  }

  for (let i = 1; i <= endTime; i++) {
    acc[i] += acc[i - 1];
  }

  while (right <= endTime) {
    if (total > max) {
      max = total;
      answer = getTime(left);
    }

    total += acc[right++];
    if (right - left > w) {
      total -= acc[left++];
    }
  }

  /* 정답 반환 */
  return answer;

  /**
   * 입력 시간(HH:MM:SS, String)을 초로 변환
   */
  function getSeconds(time) {
    const [H, M, S] = time.split(":").map((t) => +t);
    return H * hTos + M * mTos + S;
  }

  /**
   * 초를 "HH:MM:SS" 형식으로 변환
   */
  function getTime(seconds) {
    const H = Math.floor(seconds / hTos);
    seconds -= H * hTos;

    const M = Math.floor(seconds / mTos);
    seconds -= M * mTos;

    return `${H < 10 ? "0" + H : H}:${M < 10 ? "0" + M : M}:${seconds < 10 ? "0" + seconds : seconds}`;
  }
};

console.log(
  solution("02:03:55", "00:14:15", [
    "01:20:15-01:45:14",
    "00:40:31-01:00:00",
    "00:25:50-00:48:29",
    "01:30:59-01:53:29",
    "01:37:44-02:02:30",
  ])
);
console.log(
  solution("99:59:59", "25:00:00", ["69:59:59-89:59:59", "01:00:00-21:00:00", "79:59:59-99:59:59", "11:00:00-31:00:00"])
);
console.log(solution("50:00:00", "50:00:00", ["15:36:51-38:21:49", "10:14:18-15:36:51", "38:21:49-42:51:45"]));

