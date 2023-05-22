function solution(fees, records) {
  /* 입력 값 */
  const [basicTime, basicPrice, unitTime, unitPrice] = fees;

  /* 선언 값 */
  const arr = new Array(10000);

  /* 함수 */
  const handleInput = (data) => {
    const [time, carNum, inOut] = data.split(" ");
    if (inOut === "IN") {
      if (!arr[+carNum]) {
        arr[+carNum] = [time, 0, 1];
      } else {
        arr[+carNum][0] = time;
        arr[+carNum][2] = 1;
      }
      return;
    }

    const timeDiff = timeToMinutes(time) - timeToMinutes(arr[+carNum][0]);
    arr[+carNum][1] += timeDiff;
    arr[+carNum][2] = 0;
  };

  const timeToMinutes = (time) => {
    const [hr, min] = time.split(":").map((item) => +item);
    return hr * 60 + min;
  };

  /* 메인 로직 */
  const answer = [];

  for (const r of records) {
    handleInput(r);
  }

  for (let i = 0; i < 10000; i++) {
    if (!arr[i]) continue;

    if (arr[i][2] > 0) {
      arr[i][1] += timeToMinutes("23:59") - timeToMinutes(arr[i][0]);
    }

    const timeDiff = arr[i][1];
    answer.push(
      timeDiff <= basicTime
        ? basicPrice
        : basicPrice + Math.ceil((timeDiff - basicTime) / unitTime) * unitPrice
    );
  }
  return answer;
}

console.log(
  solution(
    [180, 5000, 10, 600],
    [
      "05:34 5961 IN",
      "06:00 0000 IN",
      "06:34 0000 OUT",
      "07:59 5961 OUT",
      "07:59 0148 IN",
      "18:59 0000 IN",
      "19:09 0148 OUT",
      "22:59 5961 IN",
      "23:00 5961 OUT",
    ]
  )
);

console.log(
  solution(
    [120, 0, 60, 591],
    [
      "16:00 3961 IN",
      "16:00 0202 IN",
      "18:00 3961 OUT",
      "18:00 0202 OUT",
      "23:58 3961 IN",
    ]
  )
);
