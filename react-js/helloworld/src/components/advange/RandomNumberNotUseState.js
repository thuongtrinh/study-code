import { Component } from "react";

export default class RandomNumberNotUseState extends Component {
  constructor(props) {
    super(props);
    //Khởi tạo state
    this.state = {
      number: 0,
    };
    this.randomNumber = this.randomNumber.bind(this);
  }

  randomNumber = () => {
    const number = Math.round(Math.random() * 100);
    //Cập  nhật state mới
    this.setState({
      number,
    });
  };

  render() {
    return (
      <div style={{ padding: "1%" }}>
        <b>{this.state.number}</b> <hr />
        <button onClick={this.randomNumber}>Random</button>
      </div>
    );
  }
}
