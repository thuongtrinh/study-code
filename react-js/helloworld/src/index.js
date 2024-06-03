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
import ApiGetWeather from "./components/example/api-get-weather/ApiGetWeather";
import GameRockPaperScissor from "./components/example/game-rock-paper-scissor/GameRockPaperScissor";
import TodoList from "./components/example/todo-list/TodoList";
import QuizApp from "./components/example/quiz-app/QuizApp";
import CoinFlippingApp from "./components/example/coin-flipping-app/CoinFlippingApp";
import ColorBoxApp from "./components/example/color-box-app/ColorBoxApp";

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
          <Route path="api-get-weather" element={<ApiGetWeather />} />
          <Route path="game-rock-papper-scissor" element={<GameRockPaperScissor />} />
          <Route path="to-do-list" element={<TodoList />} />
          <Route path="quiz-app" element={<QuizApp />} />
          <Route path="coin-flipping-app" element={<CoinFlippingApp />} />
          <Route path="color-box-app" element={<ColorBoxApp />} />

        </Route>
      </Routes>
    </BrowserRouter>
  </React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
