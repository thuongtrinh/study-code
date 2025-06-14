import React, { Component } from "react";
import Grid from "@mui/material/Grid";
import Typography from "@mui/material/Typography";
import AppBar from "@mui/material/AppBar";
import Toolbar from "@mui/material/Toolbar";
import TaskItem from "../TaskItem/index";
import { STATUSES } from "../../../constants";
import PropTypes from "prop-types";

class TaskList extends Component {
  render() {
    const { tasks, status, onClickEdit, onClickDelete } = this.props;
    let statusLabel = STATUSES.filter((statusObj) => {
      return statusObj.value === status.value;
    }).map((data) => data.label);

    return (
      <>
        <Grid
          size={3}
          sx={{ bgcolor: "grey.200", minHeight: "10vh" }}
          justifyContent={"center"}
        >
          <AppBar position="static">
            <Toolbar variant="dense">
              <Typography variant="h6" color="inherit" component="div">
                {statusLabel} ({tasks ? tasks.length : 0})
              </Typography>
            </Toolbar>
          </AppBar>
          {tasks.map((task) => {
            return (
              <TaskItem
                task={task}
                status={status}
                key={task.id}
                onClickEdit={() => onClickEdit(task)}
                onClickDelete={() => onClickDelete(task)}
              />
            );
          })}
        </Grid>
      </>
    );
  }
}

TaskList.propTypes = {
  tasks: PropTypes.array,
  status: PropTypes.object,
  onClickEdit: PropTypes.func,
  onClickDelete: PropTypes.func,
};

export default TaskList;
