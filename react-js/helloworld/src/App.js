import React from "react";
import "./App.css";
import Header from "./components/header/Header";
import { Outlet } from "react-router-dom";

function App() {
  return (
    <div className="App">
      <Header />
      <div className="Content">
        <Outlet />
      </div>
    </div>
  );
}

export default App;
