// TasksContext.js

import { createContext, useReducer, useContext } from "react";

// Khởi tạo Context
export const TasksContext = createContext(null);
export const TasksDispatchContext = createContext(null);

// Reducer và khởi tạo `state` ban đầu
const initialTasks = [];
const tasksReducer = (state, action) => {
  // Xử lý các hành động
};

// Thành phần cung cấp Context và Reducer
export function TasksProvider({ children }) {
  const [tasks, dispatch] = useReducer(tasksReducer, initialTasks);

  return (
    <TasksContext.Provider value={tasks}>
      <TasksDispatchContext.Provider value={dispatch}>
        {children}
      </TasksDispatchContext.Provider>
    </TasksContext.Provider>
  );
}

// Các hàm tùy chỉnh để đọc Context
export function useTasks() {
  return useContext(TasksContext);
}

export function useTasksDispatch() {
  return useContext(TasksDispatchContext);
}