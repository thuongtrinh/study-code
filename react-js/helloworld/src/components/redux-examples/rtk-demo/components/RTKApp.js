import { useDispatch, useSelector } from "react-redux";

function RTKApp({ removeTodo }) {
  const dispatch = useDispatch();
  const todoList = useSelector((state) => state.todos);
  const handleTodoClick = (todo, idx) => {
    const action = removeTodo(idx);
    dispatch(action);
  };
  return (
    <ul>
      {todoList.map((todo, idx) => (
        <li key={todo.id} onClick={() => handleTodoClick(todo, idx)}>
          {todo.title}
        </li>
      ))}
    </ul>
  );
}

export default RTKApp;
