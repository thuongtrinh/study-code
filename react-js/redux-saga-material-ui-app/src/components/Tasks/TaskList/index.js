import React, { Component } from "react";
import Grid from "@mui/material/Grid";
import Typography from "@mui/material/Typography";
import AppBar from "@mui/material/AppBar";
import Toolbar from "@mui/material/Toolbar";
import TaskItem from "../TaskItem/index";

class TaskList extends Component {
  render() {
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
                Backlog (7)
              </Typography>
            </Toolbar>
          </AppBar>
          <TaskItem />
        </Grid>
      </>
    );
  }
}

export default TaskList;
