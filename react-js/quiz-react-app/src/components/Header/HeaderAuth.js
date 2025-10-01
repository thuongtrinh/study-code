import Button from "react-bootstrap/Button";
import Container from "react-bootstrap/Container";
import Nav from "react-bootstrap/Nav";
import Navbar from "react-bootstrap/Navbar";
import "./Header.scss";
import { useLocation, useNavigate } from "react-router-dom";
import { use, useEffect, useState } from "react";

const HeaderAuth = () => {
  const location = useLocation();
  const navigate = useNavigate();
  const [isLogin, setIsLogin] = useState(true);

  useEffect(() => {
    console.log(location.pathname);
    if (location.pathname === "/login") {
      setIsLogin(true);
    } else {
      setIsLogin(false);
    }
  }, [location]);

  const handleLogin = () => {
    navigate("/login");
  };

  const handleSignup = () => {
    navigate("/register");
  };

  return (
    <div className="header-auth-container">
      <Navbar expand="lg" className="bg-body-tertiary">
        <Container fluid className="d-flex justify-content-end">
          <Nav className="d-flex auth-items">
            <Navbar.Brand>
              {isLogin
                ? "Don't have an account yet?"
                : "Already have an account?"}
            </Navbar.Brand>
            <Button
              variant="outline-success"
              onClick={isLogin ? handleSignup : handleLogin}
            >
              {isLogin ? "Sign up" : "Login"}
            </Button>
          </Nav>
        </Container>
      </Navbar>
    </div>
  );
};

export default HeaderAuth;
