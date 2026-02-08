import { Provider } from "react-redux";
import CounterRoot from "./components/CounterRoot";
import { store } from "./reducers/CounterStore";

const CounterApp = () => {
  return (
    <>
      <Provider store={store}>
        <h2>Counter App</h2>
        <hr />
        <CounterRoot />
      </Provider>
    </>
  );
};

export default CounterApp;
