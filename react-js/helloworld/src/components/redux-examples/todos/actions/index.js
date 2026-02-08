import { TodoAction } from "../constants";

let nextTodoId = 0;
export const addTodo = (text) => ({
  type: TodoAction.ADD_TODO,
  id: nextTodoId++,
  text,
});

export const toggleTodo = (id) => ({
  type: TodoAction.TOGGLE_TODO,
  id,
});

export const setVisibilityFilter = (filter) => ({
  type: TodoAction.SET_VISIBILITY_FILTER,
  filter,
});
