import * as taskConstants from "../constants/task";
import * as taskApi from "../apis/task";

export const fetchListTask = (params = {}) => {
  return {
    type: taskConstants.FETCH_TASK,
    payload: {
      params
    },
  };
};

export const fetchListTaskSuccess = (data) => {
  return {
    type: taskConstants.FETCH_TASK_SUCCESS,
    payload: {
      data
    },
  };
};

export const fetchListTaskFailed = (error) => {
  return {
    type: taskConstants.FETCH_TASK_FAILED,
    payload: {
      error
    },
  };
};

export const fetchListTaskRequest = (params = {}) => {
  return (dispatcher) => {
    dispatcher(fetchListTask());
    taskApi
      .getList()
      .then((resp) => {
        const {data} = resp;
        console.log("data: ", resp);
        dispatcher(fetchListTaskSuccess(data));
      })
      .catch((error) => {
        console.log("error: ", error);
        dispatcher(fetchListTaskFailed(error));
      });
  };
};
