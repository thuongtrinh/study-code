import { connect } from "react-redux";
import { setVisibilityFilter } from "../actions";
import LinkTodo from "../components/LinkTodo";

const mapStateToProps = (state, props) => ({
  active: props.filter === state.visibilityFilter,
});

const mapDispatchToProps = (dispatch, props) => ({
  onClick: () => dispatch(setVisibilityFilter(props.filter)),
});

export default connect(mapStateToProps, mapDispatchToProps)(LinkTodo);
