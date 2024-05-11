import { Component } from "react";

class State extends Component {
  constructor(props) {
    super(props);
    this.state = { name: "react.net" };
  }

  changeState() {
    this.setState({
      name: "react.net New",
    });
  }

  render() {
    return (
      <div>
        <p>---------------state----------------- </p>
        <h1>Học ReactJS căn bản tại {this.state.name} </h1>
        <button
          onClick={() => {
            this.setState({ name: "123" });
          }}
        >
          Change state name 1
        </button>
        <button onClick={this.changeState.bind(this)}>Change state name 2</button>
      </div>
    );
  }
}

export default State;
