import { Component } from "react";

class MyShouldComponentUpdate extends Component {
  shouldComponentUpdate(nextProps, nextState) {
    // Kiểm tra xem có sự thay đổi trong props hoặc state không
    if (this.props.foo === nextProps.foo && this.state.bar === nextState.bar) {
      return false; // Không cần render lại component
    }
    return true; // Cần render lại component
  }

  render() {
    return <div>MyShouldComponentUpdate: Nội dung component</div>;
  }
}

export default MyShouldComponentUpdate;