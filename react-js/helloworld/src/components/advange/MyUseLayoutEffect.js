import { useLayoutEffect, useRef, useState } from "react";

function MyUseLayoutEffect() {
  const [size, setSize] = useState({ width: 0, height: 0 });
  const myRef = useRef(null);

  useLayoutEffect(() => {
    setSize({
      width: myRef.current.clientWidth,
      height: myRef.current.clientHeight,
    });
  }, []);

  return (
    <div ref={myRef}>
      MyUseLayoutEffect: The size of this element is {size.width} x {size.height} pixels.
    </div>
  );
}

export default MyUseLayoutEffect;