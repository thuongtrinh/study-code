import { Component } from "react";
import { NavLink, Outlet } from "react-router-dom";

class IndexEx extends Component {
  render() {
    return (
      <>
        <h2>Example React Projects:</h2>
        <ol>
          <li>
            <NavLink to="/submission-form">Submission Form</NavLink>
          </li>
          <li>
            <NavLink to="/radom-joke">Random Joke</NavLink>
          </li>
          <li>
            <NavLink to="/password-validator">Create a Password Validator</NavLink>
          </li>
          <li>Java</li>
          <li>JavaFX</li>
        </ol>
        <div>
          <Outlet />
        </div>
      </>
    );
  }
}

export default IndexEx;
