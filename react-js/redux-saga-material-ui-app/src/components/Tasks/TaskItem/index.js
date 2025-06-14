import React, { Component } from "react";
import Card from "@mui/material/Card";
import CardContent from "@mui/material/CardContent";
import Typography from "@mui/material/Typography";
import CardActions from "@mui/material/CardActions";
import Fab from "@mui/material/Fab";
import Icon from "@mui/material/Icon";
import PropTypes from "prop-types";

class TaskItem extends Component {
  render() {
    const { task, onClickEdit, onClickDelete } = this.props;
    return (
      <>
        <Card key={task.id} sx={{ margin: 2 }}>
          <CardContent>
            <Typography gutterBottom variant="h5" component="div">
              {task.title}
            </Typography>
            <Typography variant="body2">{task.description}</Typography>
          </CardContent>
          <CardActions sx={{ justifyContent: "flex-end" }}>
            <Fab
              color="primary"
              aria-label="Edit"
              size="small"
              onClick={onClickEdit}
            >
              <Icon fontSize="small">edit_icon</Icon>
            </Fab>
            <Fab
              color="primary"
              aria-label="Delete"
              size="small"
              onClick={onClickDelete}
            >
              <Icon fontSize="small">delete_icon</Icon>
            </Fab>
          </CardActions>
        </Card>
      </>
    );
  }
}

TaskItem.propTypes = {
  task: PropTypes.object,
  status: PropTypes.object,
  onClickEdit: PropTypes.func,
  onClickDelete: PropTypes.func,
};

export default TaskItem;
