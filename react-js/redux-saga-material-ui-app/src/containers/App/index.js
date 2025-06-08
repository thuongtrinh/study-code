import { Component } from "react";
import TaskBoard from "../TaskBoard/index";
import { ThemeProvider } from "@mui/material";
import customTheme from "../../commons/Theme";
import configureStore from "../../redux/configureStore";
import { Provider } from "react-redux";
import { ToastContainer } from "react-toastify";

const store = configureStore();

class App extends Component {
  renderAdminRoutes() {
    return (
      <Provider store={store}>
        <ThemeProvider theme={customTheme}>
          <TaskBoard />
          <ToastContainer />
        </ThemeProvider>
      </Provider>
    );
  }

  render() {
    return this.renderAdminRoutes();
  }
}

export default App;
