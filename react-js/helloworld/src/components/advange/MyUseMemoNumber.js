import React, { useMemo, useState } from "react";

function MyUseMemoNumber() {
  const [length, setLength] = useState(0);

  return (
    <div>
      <input
        type="text"
        placeholder="Nhập số"
        value={length}
        onChange={(e) => setLength(Number(e.target.value))}
      />

      <ListedAllNumber length={length} />
    </div>
  );
}

function ListedAllNumber({ length }) {
  console.log("calculating...");
  //   let numbers = [];
  //   for (let i = 0; i < length; i++) {
  //     numbers.push(i);
  //   }

  // Nhưng nếu số nhập vào lớn, việc tính toán danh sách này sẽ tốn thời gian. 
  // Đây là một ví dụ rõ ràng khi cần sử dụng useMemo để cache kết quả tính toán này
  let numbers = useMemo(() => {
    let results = [];
    for (let i = 0; i < length; i++) {
      results.push(i);
    }
    return results;
  }, [length]);

  return <p>Listed number: {numbers.join(",")}</p>;
}

export default MyUseMemoNumber;
