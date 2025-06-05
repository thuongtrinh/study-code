import { Component } from "react";
import Grid from "@mui/material/Grid";
import Container from "@mui/material/Container";
import TaskList from "../../components/Tasks/TaskList";
import SearchBox from "../../components/Tasks/SearchBox";
import { connect } from "react-redux";

class TaskBoard extends Component {
  componentDidMount() {
    // const { taskActionCreators } = this.props;
    // const { fetchListTask } = taskActionCreators;
    // fetchListTask();
  }

  render() {
    return (
      <div>
        <SearchBox />
        <Container
          maxWidth="false"
          sx={{ bgcolor: "#cfe8fc", height: "100%", padding: 2 }}
        >
          <Grid container spacing={4} direction="row">
            <TaskList />
            <TaskList />
            <TaskList />
            <TaskList />
          </Grid>
        </Container>
      </div>
    );
  }
}

// const mapStateToProps = (state) => {
//   return {
//     listTask: state.task.listTask,
//   };
// };

export default TaskBoard; //connect(mapStateToProps)(TaskBoard);
