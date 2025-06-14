import React, { Component } from "react";
import TextField from "@mui/material/TextField";
import Box from "@mui/material/Box";
import Search from "@mui/icons-material/Search";
import Button from "@mui/material/Button";
import AddIcon from "@mui/icons-material/Add";
import RefreshIcon from "@mui/icons-material/Refresh";
import { connect } from "react-redux";
import { bindActionCreators } from "redux";
import * as taskActions from "./../../../actions/task";
import * as modalActions from "./../../../actions/modal";
import TaskForm from "../../../containers/TaskForm";

class SearchBox extends Component {
  handleLoadData = () => {
    const { taskActionCreators } = this.props;
    const { fetchListTask } = taskActionCreators;
    fetchListTask();
  };

  handleFilter = (e) => {
    const { value } = e.target;
    const { taskActionCreators } = this.props;
    const { filterTask } = taskActionCreators;
    filterTask(value);
  };

  openForm = () => {
    const { modalActionCreators, taskActionCreators } = this.props;
    const { setTaskEditing } = taskActionCreators;
    setTaskEditing(null);

    const { showModal, changeModalTitle, changeModalContent } =
      modalActionCreators;

    showModal();
    changeModalTitle("Add new Job");
    changeModalContent(<TaskForm />);
  };

  render() {
    return (
      <div style={{ width: "100%" }}>
        <Box display="flex">
          <Box flexGrow={1} display="flex" mt={3}>
            <Box>
              <Button
                variant="contained"
                startIcon={<AddIcon />}
                onClick={this.openForm}
              >
                New Task
              </Button>
            </Box>
            <Box ml={2}>
              <Button
                variant="outlined"
                startIcon={<RefreshIcon />}
                onClick={this.handleLoadData}
              >
                Load data
              </Button>
            </Box>
          </Box>

          <Box>
            <Search sx={{ color: "action.active", mr: 2, my: 4 }} />
            <TextField
              sx={{ width: 300 }}
              autoComplete="off"
              margin="normal"
              id="input-with-sx"
              label="Nhập từ khóa"
              onChange={this.handleFilter}
            />
          </Box>
        </Box>
      </div>
    );
  }
}

const mapDispatchToProps = (dispatch) => {
  return {
    taskActionCreators: bindActionCreators(taskActions, dispatch),
    modalActionCreators: bindActionCreators(modalActions, dispatch),
  };
};

export default connect(null, mapDispatchToProps)(SearchBox);
