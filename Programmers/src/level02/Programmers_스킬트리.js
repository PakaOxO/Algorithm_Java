/*
  Programmers_스킬트리 (level 2)
  Sketch Idea
    1. 해시와 배열을 활용하여, 스킬트리에서 선행 스킬을 배웠는지 확인
*/

const solution = (skill, skill_trees) => {
  let answer = 0;
  const skills = new Map();
  const skill_sequence = skill.split("");
  skill_sequence.forEach((s, i) => {
    skills.set(s, i);
  });

  const isPossible = (skill_tree) => {
    const tree = skill_tree.split("");
    const isVisited = new Array(skill.length).fill(false);
    for (let i = 0; i < tree.length; i++) {
      if (skills.has(tree[i])) {
        const seq = skills.get(tree[i]);
        if (seq > 0 && !isVisited[seq - 1]) {
          return false;
        }
        isVisited[seq] = true;
      }
    }
    return true;
  };

  skill_trees.forEach((s) => {
    if (isPossible(s)) {
      answer++;
    }
  });

  return answer;
};

console.log(solution("CBD", ["BACDE", "CBADF", "AECB", "BDA"]));
