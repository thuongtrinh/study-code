import React from "react";

//Component Con
const ForwardingRefsC = React.forwardRef((props, ref) => {
  return <input name={props.name} ref={ref} />;
});

// Component Cha
const ForwardingRefsP = () => {
  let ref = React.createRef();
  const handleButton = () => {
    ref.current.focus();
  };
  return (
    <>
      <code>ForwardingRefsC: </code>
      <ForwardingRefsC name="email" ref={ref} />
      <button onClick={handleButton}>Focus Input</button>
    </>
  );
};

export default ForwardingRefsP;
