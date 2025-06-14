import { Component } from "react";
import Grid from "@mui/material/Grid";
import Container from "@mui/material/Container";
import TaskList from "../../components/Tasks/TaskList";
import SearchBox from "../../components/Tasks/SearchBox";
import { connect } from "react-redux";
import * as taskActions from "./../../actions/task";
import * as modalActions from "./../../actions/modal";
import { bindActionCreators } from "redux";
import PropTypes from "prop-types";
import { STATUSES } from "../../constants";
import TaskForm from "../TaskForm";
import { Box, Button } from "@mui/material";
import { modalConfirmTextBold } from "./styles";

class TaskBoard extends Component {
  componentDidMount() {
    const { taskActionCreators } = this.props;
    const { fetchListTask } = taskActionCreators;
    fetchListTask();
  }

  handleEditTask = (task) => {
    // console.log(task);
    const { taskActionCreators, modalActionCreators } = this.props;
    const { setTaskEditing } = taskActionCreators;
    const { showModal, changeModalTitle, changeModalContent } =
      modalActionCreators;

    setTaskEditing(task);
    showModal();
    changeModalTitle("Update Job");
    changeModalContent(<TaskForm />);
  };

  handleDeleteTask(task) {
    const { id } = task;
    const { taskActionCreators } = this.props;
    const { deleteTask } = taskActionCreators;
    deleteTask(id);
  }

  showModalDeleteTask = (task) => {
    const { modalActionCreators } = this.props;
    const { showModal, hideModal, changeModalTitle, changeModalContent } =
      modalActionCreators;
    showModal();
    changeModalTitle("Delete Job");
    changeModalContent(
      <div>
        <div>
          Are you sure deleteTask{" "}
          <span className={modalConfirmTextBold}>{task.title}</span>?
        </div>
        <Box display="flex" flexDirection="row-reverse" mt={2}>
          <Box ml={1}>
            <Button variant="contained" onClick={hideModal}>
              Cancel
            </Button>
          </Box>
          <Box>
            <Button
              variant="contained"
              color="primary"
              onClick={() => this.handleDeleteTask(task)}
            >
              Agree
            </Button>
          </Box>
        </Box>
      </div>
    );
  };

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
              // console.log("listTask:", listTask)
              const taskFiltered = listTask.filter(
                (task) => task.status === status.value
              );
              return (
                <TaskList
                  key={status.value}
                  tasks={taskFiltered}
                  status={status}
                  onClickEdit={this.handleEditTask}
                  onClickDelete={this.showModalDeleteTask}
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
  taskActionCreators: PropTypes.shape({
    // fetchListTaskRequest: PropTypes.func,
    fetchListTask: PropTypes.func,
    filterTask: PropTypes.func,
    setTaskEditing: PropTypes.func,
    deleteTask: PropTypes.func,
  }),
  modalActionCreators: PropTypes.shape({
    showModal: PropTypes.func,
    hideModal: PropTypes.func,
    changeModalTitle: PropTypes.func,
    changeModalContent: PropTypes.func,
  }),
  listTask: PropTypes.array,
};

const mapStateToProps = (state) => {
  return {
    listTask: state.task.listTask,
  };
};

const mapDispatchToProps = (dispatch) => {
  return {
    taskActionCreators: bindActionCreators(taskActions, dispatch),
    modalActionCreators: bindActionCreators(modalActions, dispatch),
  };
};

export default connect(mapStateToProps, mapDispatchToProps)(TaskBoard);
