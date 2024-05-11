import { Component } from "react";

function ShowGirlFriends(props) {
  //Object chứa thông tin của người iwww :))
  const myGirlFriends = [
    {
      id: 1,
      name: "Khanh Huyen",
      email: "khanhhuyen123@freetuts.net",
    },
    {
      id: 2,
      name: "Nguyen Hang",
      email: "nguyenhang3dzas@freetuts.net",
    },
    {
      id: 3,
      name: "Pham Uyen",
      email: "phamuyenz@freetuts.net",
    },
  ];

  return (
    <ShowGirlFriends listGirlFriends={myGirlFriends}>
      {(data) => {
        //Nhận data từ component ShowGirlFriends khi nó trả về bằng đoạn props.children(person)
        console.log(data);
      }}
    </ShowGirlFriends>
  );
}

class Counter extends Component {
  constructor(props) {
    super(props);
    this.state = {
      count: 0,
    };
    //Bind this
    this.increment = this.increment.bind(this);
    this.decrement = this.decrement.bind(this);
  }

  //Hàm này sẽ TĂNGiá trị của số
  increment() {
    this.setState({
      count: this.state.count + 1,
    });
  }

  //Hàm này sẽ GIẢM giá trị của số
  decrement() {
    this.setState({
      count: this.state.count - 1,
    });
  }
  render() {
    return (
      <div>
        {
          //Trả về giá trị cho props render.
          this.props.render({
            count: this.state.count,
            increment: this.increment,
            decrement: this.decrement,
          })
        }
      </div>
    );
  }
}

function AppCounter(props) {
  return (
    <Counter
      render={(data) => {
        //Nhận giá trị trả vê từ Counter qua props render.
        const { count, increment, decrement } = data;
        return (
          <>
            <p>Giá trị {count}</p>
            <button onClick={increment}>Tăng</button>
            <button onClick={decrement}>Giảm</button>
          </>
        );
      }}
    />
  );
}

export class RenderProps extends Component {
  render() {
    return (
      <>
        <AppCounter />
      </>
    );
  }
}
