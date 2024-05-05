import { Component } from "react";
import ReactDOM from "react-dom";

class StateCountDown extends Component {
  constructor(props) {
    super(props);
    this.state = {
      index: 1,
    };
  }

  countDown() {
    this.setState({
      index: this.state.index - 1,
    });
  }

  countUp() {
    this.setState({
      index: this.state.index + 1,
    });
  }

  changeColor() {
    var title = document.getElementById("title");
    ReactDOM.findDOMNode(title).style.color = "red";
  }

  render() {
    return (
      <div>
        <p>------Component API trong ReactJS------</p>
        <p>Giá trị: {this.state.index}</p>
        <button onClick={() => this.countDown()}>Down</button>
        <button onClick={() => this.countUp()}>Up</button>
        <div>
          <p>Giá trị: {Math.random()}</p>
          <button onClick={() => this.forceUpdate()}>Reload</button>
        </div>
        <div>
          <h1 id="title">Tiêu đề</h1>
          <button onClick={() => this.changeColor()}>Change Color</button>
        </div>
      </div>
    );
  }
}

export default StateCountDown;
