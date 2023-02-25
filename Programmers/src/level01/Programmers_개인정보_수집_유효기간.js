function solution(today, terms, privacies) {
  const getExpirationDate = (date, period) => {
    let [year, month, dt] = date.split(".").map((item) => item * 1);
    if (dt === 1) {
      month += period * 1 - 1;
      dt = 28;
    } else {
      month += period * 1;
      dt--;
    }

    const addYear = Math.floor((month - 1) / 12);
    month -= addYear * 12;

    return `${year + addYear}.${month}.${dt}`;
  };

  // Main Process
  const answer = [];
  const termMap = new Map();
  for (const term of terms) {
    const [type, period] = term.split(" ");
    termMap.set(type, period);
  }

  for (let i = 0; i < privacies.length; i++) {
    const [date, type] = privacies[i].split(" ");
    const expirationDate = getExpirationDate(date, termMap.get(type));
    if (new Date(today) > new Date(expirationDate)) {
      answer.push(i + 1);
    }
  }

  return answer;
}

console.log(
  solution(
    "2022.05.19",
    ["A 6", "B 12", "C 3"],
    ["2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"]
  )
);
console.log(
  solution(
    "2020.01.01",
    ["Z 3", "D 5"],
    [
      "2019.01.01 D",
      "2019.11.15 Z",
      "2019.08.02 D",
      "2019.08.01 D",
      "2018.12.28 Z",
    ]
  )
);
