import { Navigate } from "react-router-dom";
import ReactHook from "./ReactHook";
import CounterReducer from "./CounterReducer";
import MyCompRef from "./MyCompRef";
import MyCompRefCallback from "./MyCompRefCallback";
import MyForwardRef from "./MyForwardRef";
import MyUseEffect2 from "./MyUseEffect2";
import ScrollToTop from "./ScrollToTop";
import MyUseCallbackCounter from "./MyUseCallbackCounter";
import MyUseMemoNumber from "./MyUseMemoNumber";
import CustomHooksUseOnlineStatus from "./CustomHooksUseOnlineStatus";
import MyUseImperativeHandle from "./MyImperativeHandle";

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
      <MyCompRef/><hr/>
      <MyCompRefCallback/><hr/>
      <MyForwardRef/><hr/>
      <MyUseEffect2/><hr/>
      <ScrollToTop/><hr/>
      <MyUseCallbackCounter/><hr/>
      <MyUseMemoNumber/><hr/>
      <CustomHooksUseOnlineStatus/><hr/>
      <MyUseImperativeHandle/><hr/>
    </div>
  );
}

export default LoginPage;
