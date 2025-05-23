import React from "react";
import "../css/CounterApp.css";
import { CounterDetail } from "./CounterDetail";

function CounterRoot() {
  return (
    <div className="App-counter">
      <header className="App-header">
        <img
          src={`${process.env.PUBLIC_URL ?? ""}/logo.svg`}
          className="App-logo"
          alt="logo"
        />
        <CounterDetail />
        <p>
          Edit <code>../CounterApp.js</code> and save to reload.
        </p>
        <span>
          <span>Learn </span>
          <a
            className="App-link"
            href="https://reactjs.org/"
            target="_blank"
            rel="noopener noreferrer"
          >
            React
          </a>
          <span>, </span>
          <a
            className="App-link"
            href="https://redux.js.org/"
            target="_blank"
            rel="noopener noreferrer"
          >
            Redux
          </a>
          <span>, </span>
          <a
            className="App-link"
            href="https://redux-toolkit.js.org/"
            target="_blank"
            rel="noopener noreferrer"
          >
            Redux Toolkit
          </a>
          ,<span> and </span>
          <a
            className="App-link"
            href="https://react-redux.js.org/"
            target="_blank"
            rel="noopener noreferrer"
          >
            React Redux
          </a>
        </span>
      </header>
    </div>
  );
}

export default CounterRoot;
