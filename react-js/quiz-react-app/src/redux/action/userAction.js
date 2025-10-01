export const USER_LOGIN_SUCCESS = "USER_LOGIN_SUCCESS";

export const doLogin = (data) => {
  return {
    type: USER_LOGIN_SUCCESS,
    payload: data,
  };
};
