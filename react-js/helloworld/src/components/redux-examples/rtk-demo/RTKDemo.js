import { Provider } from "react-redux";
import RTKApp from "./components/RTKApp";
import store from "./reducer/store";


const RTKDemo = () => {
  return (
    <>
      <Provider store={store}>
        <h2>RTKDemo App</h2>
        <hr />
        <br />
        <RTKApp />
      </Provider>
    </>
  );
};

export default RTKDemo;
