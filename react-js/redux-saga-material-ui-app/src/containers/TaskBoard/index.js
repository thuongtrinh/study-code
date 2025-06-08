import { Component } from "react";
import Grid from "@mui/material/Grid";
import Container from "@mui/material/Container";
import TaskList from "../../components/Tasks/TaskList";
import SearchBox from "../../components/Tasks/SearchBox";
import { connect } from "react-redux";
import * as taskActions from "./../../actions/task";
import { bindActionCreators } from "redux";
import PropTypes from "prop-types";
import { STATUSES } from "../../constants";

class TaskBoard extends Component {
  componentDidMount() {
    const { taskActionCreators } = this.props;
    const { fetchListTaskRequest } = taskActionCreators;
    fetchListTaskRequest();
  }

  render() {
    const { listTask } = this.props;
    let xhtml = (
      <div>
        <SearchBox />
        <Container
          maxWidth="false"
          sx={{ bgcolor: "#cfe8fc", height: "100%", padding: 2 }}
        >
          <Grid container spacing={4} direction="row">
            {STATUSES.map((status) => {
              const taskFiltered = listTask.filter(
                (task) => task.status === status.value
              );
              return (
                <TaskList
                  key={status.value}
                  tasks={taskFiltered}
                  status={status}
                  // onClickEdit={this.handleEditTask}
                  // onClickDelete={this.showModalDeleteTask}
                />
              );
            })}
          </Grid>
        </Container>
      </div>
    );
    return xhtml;
  }
}

TaskBoard.propTypes = {
  // classes: PropTypes.object,
  taskActionCreators: PropTypes.shape({
    fetchListTaskRequest: PropTypes.func,
  }),
  listTask: PropTypes.array
};

const mapStateToProps = (state) => {
  return {
    listTask: state.task.listTask,
  };
};

const mapDispatchToProps = (dispatch) => {
  return {
    taskActionCreators: bindActionCreators(taskActions, dispatch),
  };
};

export default connect(mapStateToProps, mapDispatchToProps)(TaskBoard);
