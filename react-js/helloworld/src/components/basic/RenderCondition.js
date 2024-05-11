import { Component } from "react";

const Notification = (props) => {
  if (props.isShow) {
    //Trả về JSX để hiển thị
    return (
      <ul>
        <li>Thông báo 1</li>
        <li>Thông báo 2</li>
      </ul>
    );
  } else {
    //Trả về null để ẩn
    return null;
  }
};

class RenderCondition extends Component {
  constructor(props) {
    super(props);
    this.state = {
        isShowNotification: false,
        s : ""
    };
  }

  render() {
    const {isShowNotification} = this.state
    return (
      <div style={{ margin: 20 }}>
        <h3>react.net - Render với điều kiện</h3>
        <button
          onClick={() => {
            this.setState({
              isShowNotification: !isShowNotification,
            });
          }}
        >
          {isShowNotification ? "Ẩn" : "Hiển thị"}
        </button>

        {/* Gọi component Notification */}
        <Notification isShow={isShowNotification} />
      </div>
    );
  }
}

export default RenderCondition;
