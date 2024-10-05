import React, { useRef, useState } from "react";
import MyImperativeInput from "./MyImperativeInput";

function MyUseImperativeHandle() {
  const [value, setValue] = useState("");
  const inputRef = useRef();

  return (
    <>
      <h3>Sử dụng useImperativeHandle trong React</h3>
      <MyImperativeInput
        ref={inputRef}
        value={value}
        onChange={(e) => setValue(e.target.value)}
      />
      <button onClick={() => inputRef.current.alertHi()}>Alert</button>
    </>
  );
}

export default MyUseImperativeHandle;
