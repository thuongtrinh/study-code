import React, { Component } from "react";
import TaskBoard from "../TaskBoard/index";
import { ThemeProvider } from "@mui/material";
import customTheme from "../../commons/Theme";
import configureStore from "../../redux/configureStore";
import { Provider } from "react-redux";
import { ToastContainer } from "react-toastify";
import GlobalLoading from "../../components/GlobalLoading";
import CommonModal from "../../components/Modals/CommonModal";

const store = configureStore();

class App extends Component {
  renderAdminRoutes() {
    return (
      <React.StrictMode>
        <Provider store={store}>
          <ThemeProvider theme={customTheme}>
            <TaskBoard />
            <ToastContainer />
            <GlobalLoading />
            <CommonModal />
          </ThemeProvider>
        </Provider>
      </React.StrictMode>
    );
  }

  render() {
    return this.renderAdminRoutes();
  }
}

export default App;
