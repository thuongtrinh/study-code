import { NavDropdown } from "react-bootstrap";
import Container from "react-bootstrap/Container";
import Nav from "react-bootstrap/Nav";
import Navbar from "react-bootstrap/Navbar";
import { useSelector } from "react-redux";
import { NavLink, useNavigate } from "react-router-dom";

const Header = () => {
  const navigate = useNavigate();
  const isAuthenticated = useSelector((state) => state.user.isAuthenticated);
  const account = useSelector((state) => state.user.account);

  const handleLogin = () => {
    navigate("/login");
  };

  const handleSignup = () => {
    navigate("/register");
  };

  return (
    <Navbar expand="lg" className="bg-body-tertiary">
      <Container>
        <NavLink to={"/"} className="navbar-brand">
          Quiz App
        </NavLink>
        <Navbar.Collapse id="basic-navbar-nav">
          <Nav className="me-auto">
            <NavLink to={"/"} className="nav-link">
              Home
            </NavLink>
            <NavLink to={"/admin"} className="nav-link">
              Admin
            </NavLink>
            <NavLink to={"/user"} className="nav-link">
              User
            </NavLink>
          </Nav>
          <Nav>
            {isAuthenticated === true ? (
              <>
                <NavDropdown title="Settings" id="basic-nav-dropdown">
                  <NavDropdown.Item>Logout</NavDropdown.Item>
                  <NavDropdown.Item>Profile</NavDropdown.Item>
                </NavDropdown>
              </>
            ) : (
              <>
                <button className="btn-login" onClick={() => handleLogin()}>
                  Login
                </button>
                <button className="btn-signup" onClick={() => handleSignup()}>
                  Signup
                </button>
              </>
            )}
          </Nav>
        </Navbar.Collapse>
      </Container>
    </Navbar>
  );
};

export default Header;
