import { NavLink } from "react-router-dom";

export default function ReduxApp() {
  return (
    <>
      <h2>Redux Projects:</h2>
      <ol>
        <li>
          <NavLink to="/redux/todos">Todo App</NavLink>
        </li>
        <li>
          <NavLink to="/redux/shopping-cart">ShoppingCart App</NavLink>
        </li>
        <li>
          <NavLink to="/redux/async">Async App</NavLink>
        </li>
        <li>
          <NavLink to="/redux/counter">Counter App</NavLink>
        </li>
        <li>
          <NavLink to="/redux/tree-view">Tree View App</NavLink>
        </li>
        <li>
          <NavLink to="/redux/real-world">Real World App</NavLink>
        </li>
        <li>
          <NavLink to="/redux/rtk-demo">Redux Toolkit App</NavLink>
        </li>
      </ol>
    </>
  );
}
