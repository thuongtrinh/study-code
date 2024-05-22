import React from "react";
import ReactDOM from "react-dom/client";
import "./index.css";
import App from "./App";
import reportWebVitals from "./reportWebVitals";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import Welcome from "./components/basic/Welcome";
import Advance from "./components/advange/Advance";
import IndexEx from "./components/example/IndexEx";
import SubmissionForm from "./components/example/forms/SubmissionForm";
import RandomJoke from "./components/example/random-joke/RandomJoke";
import PasswordValidatorApp from "./components/example/password-validator/PasswordValidatorApp";

const root = ReactDOM.createRoot(document.getElementById("root"));
root.render(
  <React.StrictMode>
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<App />}>
          <Route path="welcome" element={<Welcome />} />
          <Route path="advance" element={<Advance />} />
          <Route path="example" element={<IndexEx />} />
          <Route path="submission-form" element={<SubmissionForm />} />
          <Route path="radom-joke" element={<RandomJoke />} />
          <Route path="password-validator" element={<PasswordValidatorApp />} />
        </Route>
      </Routes>
    </BrowserRouter>
  </React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
