import { Component } from "react";

class ComponentLifeCycle extends Component {

  componentWillMount() {
    console.log("Component will mount!");
  }

  componentDidMount() {
    console.log("Component did mount!");
    this.getList();
  }

  getList = () => {
    /*** Gọi API, update state,vv...***/
  };

  shouldComponentUpdate(nextProps, nextState) {
    console.log("Component should update!");
    return true;
  }

  componentWillUpdate(nextProps, nextState) {
    console.log("Component will update!");
  }

  componentDidUpdate(prevProps, prevState) {
    console.log("Component did update!");
  }

  componentWillUnmount() {
    console.log('component will unmount')
  }

  render() {
    return (
      <div>
        <h3>Component Life Cycle: Mouting Method</h3>
      </div>
    );
  }
}

export default ComponentLifeCycle;
