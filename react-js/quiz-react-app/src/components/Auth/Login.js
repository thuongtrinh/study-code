import { Link, useNavigate } from "react-router-dom";
import "./Login.scss";
import { FcGoogle } from "react-icons/fc";
import { FaMicrosoft } from "react-icons/fa6";
import { IoIosArrowBack } from "react-icons/io";
import { useState } from "react";
import { toast } from "react-toastify";
import _ from "lodash";
import { postLogin } from "../../services/apiService";
import HeaderAuth from "../Header/HeaderAuth";
import CommonUtils from "../../utils/CommonUtils";
import { useDispatch } from "react-redux";
import * as actions from "../../redux/action/index";

function Login() {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");

  const navigate = useNavigate();
  const dispatch = useDispatch();

  const handleClickBtnLogin = async () => {
    if (_.isEmpty(email) || _.isEmpty(password)) {
      toast.error("Vui lòng nhập đầy đủ thông tin đăng nhập");
      return;
    } else if (!CommonUtils.isValidateEmail(email)) {
      toast.error("Vui lòng nhập đúng định dạng email");
      return;
    }

    let res = await postLogin(email, password);
    console.log(res);

    if (res && res.EC === 0) {
      const data = {
        access_token: res.DT.access_token,
        refresh_token: res.DT.refresh_token,
        username: res.DT.username,
        email: res.DT.email,
        role: res.DT.role,
      };
      dispatch(actions.doLogin(data));
      toast.success(res.EM);
      navigate("/");
    }

    if (res && res.EC !== 0) {
      toast.error(res.EM);
    }
  };

  return (
    <>
      <div className="auth-header">
        <HeaderAuth />
      </div>
      <main className="login-container">
        <section className="auth-card" aria-label="Login Card">
          <h1 className="brand">Quiz Login</h1>
          <p className="subtitle">Hello, who's this?</p>

          <div className="login-form">
            <div className="field">
              <label className="field-label">Email</label>
              <input
                id="email"
                type="email"
                placeholder="bruce@wayne.com"
                required
                value={email}
                onChange={(e) => setEmail(e.target.value)}
              />
            </div>

            <div className="field">
              <label className="field-label">Password</label>
              <input
                id="password"
                type="password"
                placeholder="At least 5 characters"
                required
                value={password}
                onChange={(e) => setPassword(e.target.value)}
              />
            </div>

            <div className="forgot">
              <Link href="#" className="link">
                Forgot password?
              </Link>
            </div>

            <button className="btn btn-primary" onClick={handleClickBtnLogin}>
              Log in to Quiz
            </button>

            <div className="sso">
              <IoIosArrowBack />
              <Link to={"/"} className="link">
                <i>Go back HomePage</i>
              </Link>
            </div>

            <div className="divider" aria-hidden="true">
              <span>OR</span>
            </div>

            <button
              type="button"
              className="btn btn-outline social-btn btn-google"
              aria-label="Sign in with Google"
            >
              <span className="icon" aria-hidden="true">
                <FcGoogle />
              </span>{" "}
              Sign in with Google
            </button>

            <button
              type="button"
              className="btn btn-outline social-btn btn-microsoft"
              aria-label="Sign in with Microsoft"
            >
              <span className="icon" aria-hidden="true">
                <FaMicrosoft />
              </span>{" "}
              Sign in with Microsoft
            </button>

            <div className="sso">
              <Link href="#" className="link">
                Sign In with SSO
              </Link>
            </div>
          </div>
        </section>
      </main>
    </>
  );
}

export default Login;
