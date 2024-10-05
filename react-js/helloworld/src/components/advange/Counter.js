import React, { useState } from 'react';
 
function Counter() {
  const [count, setCount] = useState(0);
 
  function increment() {
    setCount(count + 1);
  }
 
  return (
    <div>
      <p>useState: You clicked {count} times</p>
      <button onClick={increment}>Click me</button>
    </div>
  );
}

export default Counter;