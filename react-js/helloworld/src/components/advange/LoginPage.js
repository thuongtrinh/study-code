import { Navigate } from "react-router-dom";
import ReactHook from "./ReactHook";

function LoginPage(props) {
  const { isLoggedIn } = props;
  if (isLoggedIn) {
    return <Navigate to="/" />;
  }
  return (
    <div>
      <h1>Login Page, Please log in to continue</h1>
      <ReactHook/>
    </div>
  );
}

export default LoginPage;
