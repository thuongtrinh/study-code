import { useRef } from "react";

export default function MyCompRef() {
  const inputRef = useRef(null);

  const onSubmitForm = (e) => {
    e.preventDefault();
    console.log(inputRef.current.value);
  };

  return (
    <>
      <p>MyComp Ref</p>
      <form onSubmit={onSubmitForm}>
        <input type="text" ref={inputRef} />
        <button type="submit">Submit</button>
      </form>
    </>
  );
}
