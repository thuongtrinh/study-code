import React, { Component } from "react";

export default class ReactRefs extends Component {
  constructor(props) {
    super(props);
    //Khởi tạo một ref
    this.myRef = React.createRef();
  }

  handleClick = () => {
    this.myRef.current.focus();
  };

  render() {
    return (
      <>
        <span>ReactRefs: </span>
        <input
          name="email"
          onChange={this.onChange}
          ref={this.myRef}
          type="text"
        />
        <button onClick={this.handleClick}>Focus Input</button>
      </>
    );
  }
}
