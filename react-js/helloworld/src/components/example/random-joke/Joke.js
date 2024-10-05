import { useState } from "react";

const Button = (props) => {
  return <button onClick={props.callApi}>Click to generate a joke.</button>;
};

const Joke = () => {
  const [Joke, setJoke] = useState("");

  const fetchApi = () => {
    fetch("https://sv443.net/jokeapi/v2/joke/Programming?type=single")
      .then((res) => res.json())
      .then((data) => setJoke(data.joke));
  };

  return (
    <div className="joke">
      <Button callApi={fetchApi} />
      <br />
      <p>{Joke}</p>
    </div>
  );
};

export default Joke;
