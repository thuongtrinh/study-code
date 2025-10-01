import { USER_LOGIN_SUCCESS } from "../action";

const initialState = {
  account: {
    access_token: "",
    refresh_token: "",
    username: "",
    email: "",
    role: "",
  },
  isAuthenticated: false,
};

const userReducer = (state = initialState, action) => {
  switch (action.type) {
    case USER_LOGIN_SUCCESS: {
      return {
        ...state,
        account: action.payload,
        isAuthenticated: true,
      };
    }
    default:
      return state;
  }
};

export default userReducer;
