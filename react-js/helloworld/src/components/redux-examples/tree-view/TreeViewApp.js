import React from "react";
import { Provider } from "react-redux";
import treeReducer from "./reducers/index";
import generateTree from "./reducers/generateTree";
import { Node } from "./container/Node";
import { createStore } from "redux";

const tree = generateTree();
const store = createStore(treeReducer, tree);

const TreeViewApp = () => {
  return (
    <>
      <Provider store={store}>
        <h2>TreeView App</h2>
        <hr />
        <Node id={0} />
      </Provider>
    </>
  );
};

export default TreeViewApp;
