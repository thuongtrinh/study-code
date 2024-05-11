import { useMemo, useState } from "react";

function MyUseMemo({ a, b }) {
  const [number1, setNumber1] = useState(0);
  const [number2, setNumber2] = useState(0);

  const result = useMemo(() => {
    console.log("compute result");
    return number1 + number2;
  }, [number1, number2]);

  // const result = useMemo(() => {
  //   return a + b;
  // }, [a, b]);

  return (
    <>
      <p>Number 1: {number1}</p>
      <input
        value={number1}
        onChange={(e) => setNumber1(parseInt(e.target.value))}
      />
      <p>Number 2: {number2}</p>
      <input
        value={number2}
        onChange={(e) => setNumber2(parseInt(e.target.value))}
      />
      <p>MyUseMemo Result: {result}</p>

      {/* <div>MyUseMemo: {result}</div> */}
    </>
  );
}

export default MyUseMemo;
