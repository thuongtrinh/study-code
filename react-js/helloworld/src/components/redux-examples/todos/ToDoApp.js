import { Provider } from "react-redux";
import TodoList from "./components/TodoList";
import AddTodo from "./containers/AddTodo";
import { createStore } from "redux";
import todoRootReducer from "./reducers";
import Footer from "./components/Footer";

const store = createStore(todoRootReducer);

const ToDoApp = () => {
  return (
    <>
      <Provider store={store}>
        <h2>Todo App</h2>
        <br />
        <AddTodo />
        <TodoList />
        <Footer/>
      </Provider>
    </>
  );
};

export default ToDoApp;
