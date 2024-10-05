import Joke from "./Joke";
import "./Joke.css";

function RandomJoke() {
  return (
    <div className="RandomJoke">
      <h1>Joke Generator Using React and Joke API</h1>
      <Joke />
    </div>
  );
}

export default RandomJoke;
