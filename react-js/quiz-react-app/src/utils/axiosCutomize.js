import axios from "axios";
import nProgress from "nprogress";
import reduxStore from "../redux/store";

nProgress.configure({ showSpinner: false, trickleSpeed: 200 });

const axiosInstance = axios.create({
  baseURL: "http://localhost:8081",
  headers: {
    "Content-Type": "application/json",
    Accept: "application/json",
  },
});

axiosInstance.interceptors.request.use(
  (request) => {
    nProgress.start();
    const token = reduxStore?.getState()?.user?.account?.access_token;
    if (token) {
      request.headers.Authorization = `Bearer ${token}`;
    }
    return request;
  },
  function (error) {
    return Promise.reject(error);
  }
);

axiosInstance.interceptors.response.use(
  (response) => {
    nProgress.done();
    return response && response.data ? response.data : response;
  },
  function (error) {
    nProgress.done();
    return error && error.response && error.response.data
      ? error.response.data
      : Promise.reject(error);
  }
);

export default axiosInstance;
