import { Navigate } from "react-router-dom";
import ReactHook from "./ReactHook";
import CounterReducer from "./CounterReducer";

function LoginPage(props) {
  const { isLoggedIn } = props;
  if (isLoggedIn) {
    return <Navigate to="/" />;
  }
  return (
    <div>
      <h1>Login Page, Please log in to continue</h1>
      <ReactHook/><hr/>
      <h2 style={{color:'red'}}>Kungfutech</h2>
      <CounterReducer/><hr/>

    </div>
  );
}

export default LoginPage;
