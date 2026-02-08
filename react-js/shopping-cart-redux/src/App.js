import { Component } from "react";
import ItemHeader from "./components/ItemHeader";
import ItemMain from "./components/ItemMain";

class App extends Component {
  constructor(props) {
    super(props);
    this.state = {};
  }

  componentDidMount() {}

  render() {
    return (
      <div>
        <ItemHeader></ItemHeader>
        <ItemMain />
      </div>
    );
  }
}

export default App;
