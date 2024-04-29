import { Component } from "react";

class State extends Component {
    constructor(props) {
        super(props)
        this.state = { name : 'react.net' }
    }

    render() {
        return (
          <div>
            <h1>Học ReactJS căn bản tại {this.state.name} </h1>
            <button
                onClick={() => {
                    this.setState({
                        name: '123'
                    })
                }}
            >
                Change state name
            </button>
          </div>
        );
      }
}

export default State;