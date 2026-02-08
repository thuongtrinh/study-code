import { Provider } from "react-redux";
import Async from "./containers/Async";
import { thunk } from "redux-thunk";
import { createLogger } from "redux-logger";
import { applyMiddleware, createStore } from "redux";
import reducer from './reducers'

const middleware = [thunk]
if (process.env.NODE_ENV !== 'production') {
  middleware.push(createLogger())
}

const store = createStore(reducer, applyMiddleware(...middleware))

const AsyncApp = () => {
  return (
    <>
      <Provider store={store}>
        <h2>Async App</h2>
        <hr />
        <Async />
      </Provider>
    </>
  );
};

export default AsyncApp;
