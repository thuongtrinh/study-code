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
      </ol>
    </>
  );
}
