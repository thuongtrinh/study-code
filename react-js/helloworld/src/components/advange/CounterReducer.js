import React, { useReducer } from "react";

// Khởi tạo `state` ban đầu
const initialState = { count: 0 };

// Hàm reducer xử lý các hành động
function reducer(state, action) {
  switch (action.type) {
    case "INCREMENT":
      return { count: state.count + 1 };
    case "DECREMENT":
      return { count: state.count - 1 };
    default:
      return state;
  }
}

function CounterReducer() {
  // Sử dụng useReducer với reducer và initialState
  const [state, dispatch] = useReducer(reducer, initialState);

  return (
    <div>
      <h3>kungfutech: Sử dụng Reducer trong React</h3>
      <p>Count: {state.count}</p>
      <button onClick={() => dispatch({ type: "INCREMENT" })}>Increment</button>
      <button onClick={() => dispatch({ type: "DECREMENT" })}>Decrement</button>
    </div>
  );
}

export default CounterReducer;
