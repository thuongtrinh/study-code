import { useCallback, useRef, useState } from "react";

export default function MyCompRefCallback() {
  const [isShowingForm, setShowingForm] = useState(false);
  const inputRef = useRef(null);

//   const refCallback = useCallback((node) => {
//     console.log(node);
//   }, []);

  const onSubmitForm = (e) => {
    e.preventDefault();
    console.log(inputRef.current.value);
  };

  return (
    <>
      <p>MyComp Ref Callback</p>
      <button onClick={() => setShowingForm(!isShowingForm)}>
        {isShowingForm ? "To Off" : "To On"}
      </button>

      {isShowingForm && (
        <form onSubmit={onSubmitForm}>
          <input type="text" ref={inputRef} />
          <button type="submit">Submit</button>
        </form>
      )}
    </>
  );
}
