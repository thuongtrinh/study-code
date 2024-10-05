import { useReducer } from "react";

const initialTodos = [{"id":1,"text":"txt","completed":false}, {"id":2,"text":"dvd","completed":true}];
 
function reducer(state, action) {
  switch (action.type) {
    case 'ADD_TODO':
      return [...state, action.payload];
    case 'TOGGLE_TODO':
      return state.map(todo =>
        todo.id === action.payload ? { ...todo, completed: !todo.completed } : todo
      );
    case 'DELETE_TODO':
      return state.filter(todo => todo.id !== action.payload);
    default:
      return state;
  }
}
 
function MyUseReducer() {
  const [todos, dispatch] = useReducer(reducer, initialTodos);
 
  const addTodo = (newTodo) => {
    dispatch({ type: 'ADD_TODO', payload: newTodo });
  };
 
  const toggleTodo = (id) => {
    dispatch({ type: 'TOGGLE_TODO', payload: id });
  };
 
  const deleteTodo = (id) => {
    dispatch({ type: 'DELETE_TODO', payload: id });
  };
 
  return (
    <>  <p>MyUseReducer</p>
        <button onClick={() => addTodo({"id": Math.random(),"text":"txt","completed":false})}>Add</button>
        <ul>
        {todos.map((todo) => (
            <li key={todo.id}>
            <span onClick={() => toggleTodo(todo.id)} style={{ textDecoration: todo.completed ? 'line-through' : 'none' }}>
                {todo.text}
            </span>
            <button onClick={() => deleteTodo(todo.id)}>Delete</button>
            </li>
        ))}
        </ul>
    </>
  );
}
 
export default MyUseReducer;