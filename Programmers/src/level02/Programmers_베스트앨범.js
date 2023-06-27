/*
  Programmers_베스트_앨범
    1. 문제 분류 : 해시, 정렬
    2. 접근 방법
      - 먼저 모든 입력값들에 대해 루프를 돌면서, 해당 장르가 있으면 장르 추가, 없으면 원래 있던 장르에 해당 음악의 인덱스와 플레이시간을 추가(객체)
      - arr를 돌면서 먼저 전체 해당 장르에 대한 전체 플레이타임 순으로 장르를 정렬
      - 그리고 장르별로 장르 내 플레이 리스트의 플레이 타임순으로 다시 정렬
      - 모든 배열(장르별)을 순회하면서 해당 장르의 탑2(1개일 경우 1개만) 노래의 idx를 answer에 추가
*/
const solution = (genres, plays) => {
  class Music {
    constructor(idx, playtime) {
      this.idx = idx;
      this.playtime = playtime;
    }
  }

  class Genre {
    constructor(idx, name) {
      this.idx = idx;
      this.name = name;
      this.musics = [];
      this.totalPlay = 0;
    }

    add(music) {
      this.musics.push(music);
      this.totalPlay += music.playtime;
    }

    sort() {
      this.musics.sort((a, b) => b.playtime - a.playtime);
    }
  }

  const answer = [];
  const size = genres.length;
  const map = new Map();
  const arr = [];
  let pointer = 0;

  for (let i = 0; i < size; i++) {
    const [g, p] = [genres[i], plays[i]];
    if (!map.has(g)) {
      const newGenre = new Genre(pointer++, g);
      newGenre.add(new Music(i, p));
      map.set(g, newGenre);
      arr.push(newGenre);
    } else {
      map.get(g).add(new Music(i, p));
    }
  }

  arr.forEach((genre) => genre.sort());
  arr.sort((a, b) => b.totalPlay - a.totalPlay);

  for (let i = 0; i < arr.length; i++) {
    for (let j = 0; j < 2 && j < arr[i].musics.length; j++) {
      answer.push(arr[i].musics[j].idx);
    }
  }
  return answer;
};

console.log(
  solution(
    ["classic", "pop", "classic", "classic", "pop"],
    [500, 600, 150, 800, 2500]
  )
);
