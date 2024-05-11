import { useCallback, useState } from "react";

function MyUseCallback(props) {

  const [count, setCount] = useState(0);

  const handleClick = useCallback(() => {
    setCount(count + 1);
  }, [count]);

  return (
    <>
      <p>Count: {count}</p>
      <button onClick={handleClick}>MyUseCallback: Click me</button>
    </>
  );
}

export default MyUseCallback;
