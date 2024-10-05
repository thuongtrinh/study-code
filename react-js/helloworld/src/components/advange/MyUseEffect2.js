import React, { useEffect, useState } from "react";

function MyUseEffect2() {
  const [count, setCount] = useState(0);

  useEffect(() => {
    // Code trong useEffect sẽ thực hiện sau mỗi lần render
    document.title = `Count: ${count}`;
  }, [count]);

  return (
    <div>
      <p>MyUseEffect2 - Count: {count}</p>
      <button onClick={() => setCount(count + 1)}>Increase Count</button>
    </div>
  );
}

export default MyUseEffect2;
