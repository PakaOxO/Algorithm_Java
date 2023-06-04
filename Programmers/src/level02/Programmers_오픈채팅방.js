const solution = (record) => {
  const users = {};
  const chats = [];
  const chatTextMapper = {
    Enter: "님이 들어왔습니다.",
    Leave: "님이 나갔습니다.",
  };

  const len = record.length;
  for (let i = 0; i < len; i++) {
    const [type, id, nickname] = record[i].split(" ");
    if (type !== "Change") {
      chats.push({
        id,
        type,
      });
    }
    if (type === "Enter" || type === "Change") {
      users[id] = nickname;
    }
  }

  const answer = [];
  for (let i = 0; i < chats.length; i++) {
    if (chats[i].type === "Enter") {
      answer.push(`${users[chats[i].id]}님이 들어왔습니다.`);
    } else if (chats[i].type === "Leave") {
      answer.push(`${users[chats[i].id]}님이 나갔습니다.`);
    }
  }
  return chats.map((chat) => `${users[chat.id]}${chatTextMapper[chat.type]}`);
};

console.log(
  solution([
    "Enter uid1234 Muzi",
    "Enter uid4567 Prodo",
    "Leave uid1234",
    "Enter uid1234 Prodo",
    "Change uid4567 Ryan",
  ])
);
