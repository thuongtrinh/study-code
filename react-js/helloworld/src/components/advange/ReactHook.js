import { Component } from "react";
import Counter from "./Counter";
import MyUseEffect from "./MyUseEffect";
import MyUseReducer from "./MyUseReducer";
import MyUseCallback from "./MyUseCallback";
import MyUseMemo from "./MyUseMemo";
import MyUseRef from "./MyUseRef";
import MyUseLayoutEffect from "./MyUseLayoutEffect";
import MyShouldComponentUpdate from "./MyShouldComponentUpdate";
import MyReactLazy from "./MyReactLazy";
import RandomNumberComponent from "./RandomNumberComponent";
import MoreContentUseState from "./MoreContentUseState";
import RandomNumberNotUseState from "./RandomNumberNotUseState";
import MyUseContext from "./MyUseContext.js";

class ReactHook extends Component {

  render() {
    return (
      <div>
        <hr/>
        <h3>React Hook</h3>
        <Counter/><hr/>
        <MyUseEffect/><hr/>
        <MyUseReducer/><hr/>
        <MyUseCallback/><hr/>
        <MyUseMemo/><hr/>
        <MyUseRef/><hr/>
        <MyUseLayoutEffect/><hr/>
        <MyShouldComponentUpdate/><hr/>
        <MyReactLazy/><hr/>
        <RandomNumberComponent/><hr/>
        <RandomNumberNotUseState/><hr/>
        <MoreContentUseState/><hr/>
        <MyUseContext/>
      </div>
    );
  }
}

export default ReactHook;
