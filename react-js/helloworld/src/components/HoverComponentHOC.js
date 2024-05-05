import React from "react";

//Đây được gọi là một HOC, nó nhận vào 1 component và trả ra một component
const withHoverOpacity = (ImageComponent) => {
  return class extends React.Component {
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
        <div
          style={{ opacity: this.state.opacity }}
          onMouseEnter={this.onMouseEnter}
          onMouseLeave={this.onMouseLeave}
        >
          <ImageComponent />
        </div>
      );
    }
  };
};


//Các component là các ảnh cần Hover
const Image1 = (props) => {
  return <img src="https://www.google.com/images/branding/googlelogo/2x/googlelogo_color_92x30dp.png" alt="google" />;
};

const Image2 = (props) => {
  return (
    <img
      src="https://blog.jetbrains.com/wp-content/uploads/2024/04/JetBrains-logo.svg"
      alt="intellij"
    />
  );
};
 
//Lúc này mình truyền vào HOC một component và mình sẽ nhận vào một component mới
//Ở đây mình có thể hiển thị rất nhiều ảnh mà không cần phải xây dựng component hỗ trợ việc làm mờ ảnh quá nhiều
const ImageWithHoverOpacity1 = withHoverOpacity(Image1);
const ImageWithHoverOpacity2 = withHoverOpacity(Image2);

//Hiển thi component
// eslint-disable-next-line import/no-anonymous-default-export
export default function () {
  return (
    <>
      <ImageWithHoverOpacity1 />
      <ImageWithHoverOpacity2 />
    </>
  );
}