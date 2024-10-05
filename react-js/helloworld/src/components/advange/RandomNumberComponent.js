import { useState } from "react";

export default function RandomNumberComponent(props) {
  const [number, setNumber] = useState(0);

  return (
    <div style={{ padding: "1%" }}>
      <b>{number}</b><br/>
      <button
        onClick={() => {
          setNumber(Math.round(Math.random() * 100));
        }}
      >
        Random
      </button>
    </div>
  );
}
