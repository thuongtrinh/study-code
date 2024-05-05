import { Component } from "react";

class EventMouseClick extends Component {
  constructor(props) {
    super(props);
    this.state = {
      buttonClick: "",
      textareaContent: "",
      moveOver: "",
    };
  }

  changeText(e) {
    this.setState({
      textareaContent: e.target.value,
    });
  }

  moveMouseOver() {
    this.setState({
      moveOver: this.state.moveOver + "moving...",
    });
  }

  render() {
    return (
      <div>
        <button
          onClick={() => {
            this.setState({
              buttonClick: this.state.buttonClick + "onClick...",
            });
          }}
        >
          Click me...
        </button>
        <p>button click me: {this.state.buttonClick}</p>
        <p>------------------------------</p>
        <textarea onChange={this.changeText.bind(this)}></textarea>
        <p>textarea content: {this.state.textareaContent}</p>
        <p>------------------------------</p>
        <h3 onMouseOver={() => this.moveMouseOver()}>Move mouse this text</h3>
        <p>moverOver: {this.state.moveOver}</p>
      </div>
    );
  }
}

export default EventMouseClick;
