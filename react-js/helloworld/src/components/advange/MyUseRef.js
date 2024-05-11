import { useEffect, useRef } from "react";

function MyUseRef() {
  const myRef = useRef(null);

  //vd1
  useEffect(() => {
    myRef.current.textContent = "MyUseRef: Hello, world!";
  }, []);

  //vd2
  const countRef = useRef(0);
  const incrementCount = () => {
    countRef.current += 1;
    console.log(`Count is ${countRef.current}`);
  };

  return (
  <div>
        <div ref={myRef}></div>;
        <button onClick={incrementCount}>Increment count</button>
  </div>
  )
}

export default MyUseRef;
