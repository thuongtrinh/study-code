import { forwardRef, useRef } from "react";

const MyInput = forwardRef((props, ref) => {
  return <input {...props} ref={ref} />;
});

export default function MyForwardRef() {
  const inputRef = useRef(null);

  function handleClick() {
    inputRef.current.focus();
  }

  return (
    <>
      <p>MyForwardRef</p>
      <MyInput ref={inputRef} />
      <button onClick={handleClick}>focus vào ô nhập</button>
    </>
  );
}
