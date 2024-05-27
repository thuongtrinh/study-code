import React, { Component } from "react";

class Coin extends Component {
  render() {
    return (
      <div className="Coin">
        <img
          alt={'couin_' + this.props.info.side}
          style={{ width: "200px", height: "200px" }}
          src={this.props.info.imgSrc}
        />
      </div>
    );
  }
}

export default Coin;
