/* eslint-disable jsx-a11y/anchor-is-valid */
import React from "react";
import { Component } from "react";
import { connect } from "react-redux";
import * as actions from "../actions/index";

export class Node extends Component {
  handleIncrementClick = () => {
    console.log(this.props);
    const { increment, id } = this.props;
    increment(id);
  };

  handleAddChildClick = (e) => {
    e.preventDefault();

    const { addChild, createNode, id } = this.props;
    const childId = createNode().nodeId;
    addChild(id, childId);
  };

  handleRemoveClick = (e) => {
    e.preventDefault();

    const { removeChild, deleteNode, parentId, id } = this.props;
    removeChild(parentId, id);
    deleteNode(id);
  };

  renderChild = (childId) => {
    const { id } = this.props;
    return (
      <li key={childId}>
        <ConnectedNode id={childId} parentId={id} />
      </li>
    );
  };

  render() {
    const { counter, parentId, childIds } = this.props;
    console.log("render", this.props);
    return (
      <div>
        Counter: {counter}{" "}
        <button onClick={this.handleIncrementClick}>+</button>{" "}
        {typeof parentId !== "undefined" && (
          <a
            href="#"
            onClick={this.handleRemoveClick}
            style={{ color: "lightgray", textDecoration: "none" }}
          >
            ×
          </a>
        )}
        <ul>
          {childIds ? childIds.map(this.renderChild) : null}
          <li key="add">
            <a href="#" onClick={this.handleAddChildClick}>
              Add child
            </a>
          </li>
        </ul>
      </div>
    );
  }
}

function mapStateToProps(state, ownProps) {
  console.log("mapStateToProps", state, ownProps);
  return state[ownProps.id];
}

const mapDispatchToProps = (dispatch) => ({ //actions
  increment: (id) => dispatch(actions.increment(id)),
});

const ConnectedNode = connect(() => mapStateToProps, mapDispatchToProps)(Node);
export default ConnectedNode;
