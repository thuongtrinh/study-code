import Root from "./containers/Root";
import configureStore from "./store/configureStore";

const store = configureStore();

const RealWorldApp = () => {
  return (
    <div>
      <h2>Real World App</h2>
      <hr />
      <br />
      <Root store={store} />
    </div>
  );
};

export default RealWorldApp;
