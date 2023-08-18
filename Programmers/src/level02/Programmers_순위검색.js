/**
 * Programmers_순위 검색
 *    1. 문제 분류 : 문자열, 해시, 이진탐색
 *    2. 접근 방법
 *      - 객체의 키(해시)를 통해 탐색
 *      - 점수에 도달하면 이진 탐색으로 기준 점수보다 높은 사람의 인덱스를 반환
 */
const solution = (info, query) => {
  /* 변수 초기화 */
  const answer = [];
  const dp = {};
  const participants = {
    python: {
      frontend: {
        junior: {
          chicken: [],
          pizza: [],
        },
        senior: { chicken: [], pizza: [] },
      },
      backend: {
        junior: {
          chicken: [],
          pizza: [],
        },
        senior: { chicken: [], pizza: [] },
      },
    },
    cpp: {
      frontend: {
        junior: {
          chicken: [],
          pizza: [],
        },
        senior: { chicken: [], pizza: [] },
      },
      backend: {
        junior: {
          chicken: [],
          pizza: [],
        },
        senior: { chicken: [], pizza: [] },
      },
    },
    java: {
      frontend: {
        junior: {
          chicken: [],
          pizza: [],
        },
        senior: { chicken: [], pizza: [] },
      },
      backend: {
        junior: {
          chicken: [],
          pizza: [],
        },
        senior: { chicken: [], pizza: [] },
      },
    },
  };

  /* 메인 로직 */
  info.forEach((i) => {
    const [lang, position, career, soulFood, score] = i.split(" ");
    participants[lang][position][career][soulFood].push(score);
  });

  query.forEach((q) => {
    const [lang, position, career, soulFood, score] = q.split(" ").filter((item) => item !== "and");
    if (!dp[lang]) {
      dp[lang] = find(lang, participants);
    }
    if (!dp[lang][position]) {
      dp[lang][position] = [];
      dp[lang].forEach((data) => {
        dp[lang][position].push(...find(position, data));
      });
    }
    if (!dp[lang][position][career]) {
      dp[lang][position][career] = [];
      dp[lang][position].forEach((data) => {
        dp[lang][position][career].push(...find(career, data));
      });
    }
    if (!dp[lang][position][career][soulFood]) {
      dp[lang][position][career][soulFood] = [];
      dp[lang][position][career].forEach((data) => {
        find(soulFood, data).forEach((s) => {
          s.forEach((ss) => {
            dp[lang][position][career][soulFood].push(+ss);
          });
        });
      });
      dp[lang][position][career][soulFood].sort((a, b) => b - a);
    }
    // let count = 0;
    // for (let i = 0; i < dp[lang][position][career][soulFood].length; i++) {
    //   if (dp[lang][position][career][soulFood][i] < score) break;
    //   count++;
    // }
    const count = binarySearch(score, dp[lang][position][career][soulFood]);
    answer.push(count);
  });

  return answer;

  function find(keyword, data) {
    const result = [];
    if (keyword === "-") {
      const keys = Object.keys(data);
      for (const key of keys) {
        result.push(data[key]);
      }
    } else {
      result.push(data[keyword]);
    }
    return result;
  }

  function binarySearch(score, data) {
    let [left, right] = [0, data.length];
    while (left < right) {
      const mid = ~~((left + right) / 2);
      if (data[mid] >= score) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }
    return right;
  }
};

console.log(
  solution(
    [
      "java backend junior pizza 150",
      "python frontend senior chicken 210",
      "python frontend senior chicken 150",
      "cpp backend senior pizza 260",
      "java backend junior chicken 80",
      "python backend senior chicken 50",
    ],
    [
      "java and backend and junior and pizza 100",
      "python and frontend and senior and chicken 200",
      "cpp and - and senior and pizza 250",
      "- and backend and senior and - 150",
      "- and - and - and chicken 100",
      "- and - and - and - 150",
    ]
  )
);

