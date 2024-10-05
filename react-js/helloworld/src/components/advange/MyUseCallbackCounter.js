import { useCallback, useState } from "react";

function MyUseCallbackCounter() {
  const [count, setCount] = useState(0);
  const [countOther, setCountOther] = useState(0);

  //   const increase = () => setCount(count + 1);
  //   const decrease = () => setCount(count - 1);

  //   const increaseOther = () => setCountOther(countOther + 1);
  //   const decreaseOther = () => setCountOther(countOther - 1);

  // sử dụng useCallback để memoize (cache) lại các hàm giữa các lần render
  const increase = useCallback(() => setCount(count + 1), [count]);
  const decrease = useCallback(() => setCount(count - 1), [count]);
  const increaseOther = useCallback(
    () => setCountOther(countOther + 1),
    [countOther]
  );
  const decreaseOther = useCallback(
    () => setCountOther(countOther - 1),
    [countOther]
  );

  return (
    <>
      <p>Counter useCallback để memoize</p>
      <div>Count: {count}</div>
      <button onClick={increase}>+</button>
      <button onClick={decrease}>-</button>

      <div>Count other: {countOther}</div>
      <button onClick={increaseOther}>+</button>
      <button onClick={decreaseOther}>-</button>
    </>
  );
}

export default MyUseCallbackCounter;
