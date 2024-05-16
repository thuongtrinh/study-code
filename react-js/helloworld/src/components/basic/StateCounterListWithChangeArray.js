import { useState } from "react";

let initialCounters = [0, 0, 0];

export default function StateCounterListWithChangeArray() {
  const [counters, setCounters] = useState(initialCounters);

  function handleIncrementClick(index) {
    const nextCounters = counters.map((c, i) => {
      if (i === index) {
        // Tăng giá trị của counter đã nhấp
        return c + 1;
      } else {
        // Các phần tử khác không thay đổi
        return c;
      }
    });
    setCounters(nextCounters);
  }

  return (
    <>
      <h3>Thay thế phần tử trong mảng trong state của React</h3>
      <ul>
        {counters.map((counter, i) => (
          <li key={i}>
            {counter}
            <button
              onClick={() => {
                handleIncrementClick(i);
              }}
            >
              +1
            </button>
          </li>
        ))}
      </ul>
    </>
  );
}
