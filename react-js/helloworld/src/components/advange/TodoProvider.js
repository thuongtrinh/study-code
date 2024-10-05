import { useState } from "react";
import { TodoContext } from "./TodoContext";

function TodoProvider({ children }) {
  const [todos, setTodos] = useState([]);

  const addTodo = (newTodo) => {
    setTodos([...todos, newTodo]);
  };

  return (
    <TodoContext.Provider value={{ todos, addTodo }}>
      {children}
    </TodoContext.Provider>
  );
}

export default TodoProvider;
