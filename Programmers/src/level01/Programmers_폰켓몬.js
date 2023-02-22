function solution(nums) {
  const set = new Set();
  for (const num of nums) {
    set.add(num);
  }
  return set.size < nums.length / 2 ? set.size : nums.length / 2;
}
