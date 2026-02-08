import { Box, Button, Grid, MenuItem } from "@mui/material";
import { Component } from "react";
import { styleField } from "./style";
import { connect } from "react-redux";
import { bindActionCreators, compose } from "redux";
import * as modalActions from "./../../actions/modal";
import * as taskActions from "./../../actions/task";
import { Field, reduxForm } from "redux-form";
import renderTextField from "../../components/FormHelper/TextField";
import renderSelectField from "../../components/FormHelper/Select";

import validate from "./validate";
import PropTypes from "prop-types";

class TaskForm extends Component {
  componentDidMount() {
    this.props.initialize(this.props.initialValues); // here add this line to initialize the form
  }

  handleSubmitForm = (data) => {
    const { taskActionsCreators, taskEditing } = this.props;
    const { addTask, updateTask } = taskActionsCreators;
    const { title, description, status } = data;
    if (taskEditing && taskEditing.id) {
      updateTask(title, description, status);
    } else {
      addTask(title, description);
    }
  };

  renderStatusSelection() {
    let xhtml = null;
    const { taskEditing } = this.props;
    if (taskEditing && taskEditing.id) {
      xhtml = (
        <Grid size={12}>
          <Field
            id="status"
            label="Status"
            name="status"
            sx={styleField}
            margin="normal"
            component={renderSelectField}
          >
            <MenuItem value={0}>Backlog</MenuItem>
            <MenuItem value={1}>In Progress</MenuItem>
            <MenuItem value={2}>Review</MenuItem>
            <MenuItem value={3}>Done</MenuItem>
          </Field>
        </Grid>
      );
    }
    return xhtml;
  }

  render() {
    const { modalActionCreators, handleSubmit, invalid, submitting } =
      this.props;
    const { hideModal } = modalActionCreators;

    return (
      <form onSubmit={handleSubmit(this.handleSubmitForm)}>
        <Grid container>
          <Grid size={12}>
            <Field
              id="title"
              name="title"
              label="Title"
              sx={styleField}
              margin="normal"
              component={renderTextField}
            />
          </Grid>
          <Grid size={12}>
            <Field
              id="description"
              name="description"
              label="Description"
              multiline
              maxRows="5"
              sx={styleField}
              margin="normal"
              component={renderTextField}
            />
          </Grid>
          {this.renderStatusSelection()}
          <Grid size={12}>
            <Box display="flex" flexDirection="row-reverse" mt={2}>
              <Box ml={1}>
                <Button variant="contained" onClick={hideModal}>
                  Hủy Bỏ
                </Button>
              </Box>
              <Button
                disabled={invalid || submitting}
                variant="contained"
                color="primary"
                type="submit"
              >
                Lưu Lại
              </Button>
            </Box>
          </Grid>
        </Grid>
      </form>
    );
  }
}

TaskForm.propTypes = {
  modalActionCreators: PropTypes.shape({
    hideModal: PropTypes.func,
  }),
  taskActionsCreators: PropTypes.shape({
    addTask: PropTypes.func,
    updateTask: PropTypes.func,
  }),
  handleSubmit: PropTypes.func,
  invalid: PropTypes.bool,
  submitting: PropTypes.bool,
  taskEditing: PropTypes.object,
};

const mapStateToProps = (state) => {
  return {
    taskEditing: state.task.taskEditing,
    initialValues: {
      title: state.task.taskEditing ? state.task.taskEditing.title : null,
      description: state.task.taskEditing
        ? state.task.taskEditing.description
        : null,
      status: state.task.taskEditing ? state.task.taskEditing.status : null,
    },
  };
};

const mapDispatchToProps = (dispatch) => {
  return {
    modalActionCreators: bindActionCreators(modalActions, dispatch),
    taskActionsCreators: bindActionCreators(taskActions, dispatch),
  };
};

const withConnect = connect(mapStateToProps, mapDispatchToProps);

const FORM_NAME = "TASK_MANAGEMENT";
const withReduxForm = reduxForm({
  form: FORM_NAME,
  validate,
  enableReinitialize: true,
});

export default compose(withConnect, withReduxForm)(TaskForm);
