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
          <li>
            <NavLink to="/api-get-weather">API request in get Weather</NavLink>
          </li>
          <li>
            <NavLink to="/game-rock-papper-scissor">Create Rock Paper Scissor Game</NavLink>
          </li>
          <li>
            <NavLink to="/to-do-list">To Do List</NavLink>
          </li>
          <li>
            <NavLink to="/quiz-app">Create a Quiz App</NavLink>
          </li>
        </ol>
        <div>
          <Outlet />
        </div>
      </>
    );
  }
}

export default IndexEx;
