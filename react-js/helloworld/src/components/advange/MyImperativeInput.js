import React, { useImperativeHandle } from "react";

function MyImperativeInput(props, ref) {
  useImperativeHandle(
    ref,
    () => {
      return { alertHi: () => alert(props.value) };
    },
    [props.value]
  );

  return <input ref={ref} style={{ backgroundColor: "red" }} {...props} />;
}

export default React.forwardRef(MyImperativeInput);