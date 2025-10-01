import { combineReducers } from "redux";
import userReducer from "./userReducer";
import autoMergeLevel2 from "redux-persist/es/stateReconciler/autoMergeLevel2";
import storage from "redux-persist/lib/storage";
import { persistReducer } from "redux-persist";

const persistCommonConfig = {
  storage,
  stateReconciler: autoMergeLevel2,
};

const userPersistConfig = {
  ...persistCommonConfig,
  key: "user",
  // whitelist: ["access_token", "refresh_token"]
};

export default () =>
  combineReducers({
    user: persistReducer(userPersistConfig, userReducer),
  });
