import React, { Component } from "react";
import Card from "@mui/material/Card";
import CardContent from "@mui/material/CardContent";
import Typography from "@mui/material/Typography";
import CardActions from "@mui/material/CardActions";
import Fab from "@mui/material/Fab";
import Icon from "@mui/material/Icon";

class TaskItem extends Component {
  render() {
    const { task } = this.props;
    return (
      <>
        <Card key={task.id} sx={{ margin: 2 }}>
          <CardContent>
            <Typography gutterBottom variant="h5" component="div">
              {task.title}
            </Typography>
            <Typography variant="body2">
              {task.description}
            </Typography>
          </CardContent>
          <CardActions sx={{ justifyContent: "flex-end" }}>
            <Fab color="primary" aria-label="Edit" size="small">
              <Icon fontSize="small">edit_icon</Icon>
            </Fab>
            <Fab color="primary" aria-label="Delete" size="small">
              <Icon fontSize="small">delete_icon</Icon>
            </Fab>
          </CardActions>
        </Card>
      </>
    );
  }
}

export default TaskItem;
