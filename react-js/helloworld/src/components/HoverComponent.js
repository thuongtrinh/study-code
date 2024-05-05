import React from "react";

const Image = (props) => {
  return (
    <img
      src="https://www.google.com/images/branding/googlelogo/2x/googlelogo_color_92x30dp.png"
      alt="google"
    />
  );
};

export default class HoverComponent extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      opacity: 1,
    };

    //bind this
    this.onMouseLeave = this.onMouseLeave.bind(this);
    this.onMouseEnter = this.onMouseEnter.bind(this);
  }

  //Được gọi khi chuột được di vào
  onMouseEnter() {
    this.setState({
      opacity: 0.5,
    });
  }

  //Được gọi khi chuột được rời đi
  onMouseLeave() {
    this.setState({
      opacity: 1,
    });
  }

  render() {
    return (
      <>
        <h3>Higher-Order Components trong ReactJS</h3>
        <div
          style={{ opacity: this.state.opacity }}
          onMouseEnter={this.onMouseEnter}
          onMouseLeave={this.onMouseLeave}
        >
          <Image />
        </div>
      </>
    );
  }
}
