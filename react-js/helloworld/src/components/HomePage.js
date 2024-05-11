import { Component } from "react";
import { NavLink, Outlet } from "react-router-dom";

class HomePage extends Component {
  render() {
    return (
      <>
        <nav>
          <ul>
          <li>
              <NavLink to="/">Home</NavLink>
            </li>
            <li>
              <NavLink to="/welcome">Welcome</NavLink>
            </li>
            <li>
              <NavLink to="/login">Login</NavLink>
            </li>
          </ul>
        </nav>
        <Outlet />
      </>
    );
  }
}

export default HomePage;
