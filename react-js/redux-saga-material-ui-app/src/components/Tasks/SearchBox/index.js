import React, { Component } from "react";
import TextField from "@mui/material/TextField";
import Box from "@mui/material/Box";
import Search from "@mui/icons-material/Search";
import Button from "@mui/material/Button";
import AddIcon from "@mui/icons-material/Add";
import RefreshIcon from "@mui/icons-material/Refresh";

class SearchBox extends Component {
  render() {
    return (
      <div style={{ width: "100%" }}>
        <Box display="flex">
          <Box flexGrow={1} display="flex" mt={3}>
            <Box>
              <Button variant="contained" startIcon={<AddIcon />}>
                New Task
              </Button>
            </Box>
            <Box ml={2}>
              <Button variant="outlined" startIcon={<RefreshIcon />}>
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
            />
          </Box>
        </Box>
      </div>
    );
  }
}

export default SearchBox;
