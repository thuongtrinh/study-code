import { logger } from "redux-logger";
import { createStore, applyMiddleware, compose } from "redux";
import { createStateSyncMiddleware } from "redux-state-sync";
import { persistStore } from "redux-persist";
import createRootReducer from "./reducer/rootReducer";
import { thunk } from "redux-thunk";
import { PERSIST, PURGE, REHYDRATE } from "redux-persist/es/constants";

const environment = process.env.NODE_ENV || "development";
let isDevelopment = environment === "development";

//hide redux logs
isDevelopment = true;

const reduxStateSyncConfig = {
  blacklist: [PERSIST, PURGE, REHYDRATE],
};

const rootReducer = createRootReducer();
const middleware = [thunk, createStateSyncMiddleware(reduxStateSyncConfig)];
if (isDevelopment) middleware.push(logger);

const composeEnhancers =
  isDevelopment && window.__REDUX_DEVTOOLS_EXTENSION_COMPOSE__
    ? window.__REDUX_DEVTOOLS_EXTENSION_COMPOSE__({
        shouldHotReload: false,
      })
    : compose;

const reduxStore = createStore(
  rootReducer,
  composeEnhancers(applyMiddleware(...middleware))
);

export const persistor = persistStore(reduxStore);
export default reduxStore;
