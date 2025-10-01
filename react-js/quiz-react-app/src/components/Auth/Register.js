import { Link, useNavigate } from "react-router-dom";
import "./Register.scss";
import { IoIosArrowBack } from "react-icons/io";
import HeaderAuth from "../Header/HeaderAuth";
import { useState } from "react";
import { toast } from "react-toastify";
import _ from "lodash";
import { postRegister } from "../../services/apiService";
import CommonUtils from "../../utils/CommonUtils";

function Register() {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [username, setUsername] = useState("");

  const navigate = useNavigate();

  const handleClickBtnRegister = async () => {
    if (_.isEmpty(email) || _.isEmpty(password)) {
      toast.error("Vui lòng nhập đầy đủ thông tin đăng nhập");
      return;
    } else if (!CommonUtils.isValidateEmail(email)) {
      toast.error("Vui lòng nhập đúng định dạng email");
      return;
    }

    if (_.isEmpty(username) || CommonUtils.isBlank(username)) {
      setUsername(null);
    }

    let res = await postRegister(email, password, username);
    console.log(res);

    if (res && res.EC === 0) {
      toast.success(res.EM);
      navigate("/login");
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
      <main className="register-container">
        <section className="auth-card" aria-label="Register Card">
          <h1 className="brand">Quiz Register</h1>
          <p className="subtitle">Hello, who's this?</p>

          <div className="register-form">
            <div className="field">
              <label className="field-label">
                Email <span className="field-required">(*)</span>
              </label>
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
              <label className="field-label">
                Password <span className="field-required">(*)</span>
              </label>
              <input
                id="password"
                type="password"
                placeholder="At least 5 characters"
                required
                value={password}
                onChange={(e) => setPassword(e.target.value)}
              />
            </div>

            <div className="field">
              <label className="field-label">Username</label>
              <input
                id="username"
                type="text"
                placeholder="bruce"
                required
                value={username}
                onChange={(e) => setUsername(e.target.value)}
              />
            </div>

            <button
              className="btn btn-primary"
              onClick={handleClickBtnRegister}
            >
              Create account
            </button>

            <div className="back-home">
              <IoIosArrowBack />
              <Link to={"/"} className="link">
                <i>Go back HomePage</i>
              </Link>
            </div>
          </div>
        </section>
      </main>
    </>
  );
}

export default Register;
