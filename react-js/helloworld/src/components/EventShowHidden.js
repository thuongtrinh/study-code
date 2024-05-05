import { Component } from "react";

class EventShowHidden extends Component {
  constructor(props) {
    super(props);
    this.state = {
      isShow: true,
    };
  }

  toggleMSG() {
    this.setState({
      isShow: !this.state.isShow,
    });
  }

  render() {
    return (
      <div>
        <p>--------------Xử lý Events------------------</p>
        <b>Nội dung: {this.state.isShow ? "React.net" : ""}</b><br/>
        <button onClick={() => this.toggleMSG()}>
          {this.state.isShow ? "Hide" : "Show"}
        </button>
        <br/><br/>
      </div>
    );
  }
}

export default EventShowHidden;
