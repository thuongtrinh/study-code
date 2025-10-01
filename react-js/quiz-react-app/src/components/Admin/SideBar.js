import {
  ProSidebar,
  Menu,
  MenuItem,
  SubMenu,
  SidebarHeader,
  SidebarFooter,
  SidebarContent,
} from "react-pro-sidebar";

import {
  FaTachometerAlt,
  FaGem,
  FaList,
  FaGithub,
  FaHeart,
} from "react-icons/fa";

import sidebarBg from "../../assets/sideBarbg.jpg";
import { MdFeaturedPlayList } from "react-icons/md";
import { DiReact } from "react-icons/di";
import { Link, useNavigate } from "react-router-dom";
import "./SideBar.scss";

const SideBar = (props) => {
  const { collapsed, toggled, handleToggleSidebar } = props;
  const navigate = useNavigate();

  const handleClickToHome = () => {
    navigate("/");
  };

  return (
    <div className="sidebar-container">
      <ProSidebar
        image={sidebarBg ? sidebarBg : false}
        collapsed={collapsed}
        toggled={toggled}
        breakPoint="md"
        onToggle={handleToggleSidebar}
      >
        <SidebarHeader>
          <div
            style={{
              padding: "24px",
              textTransform: "uppercase",
              fontWeight: "bold",
              fontSize: 14,
              letterSpacing: "1px",
              overflow: "hidden",
              textOverflow: "ellipsis",
              whiteSpace: "nowrap",
            }}
          >
            <span className="logo" onClick={() => handleClickToHome()}>
              <DiReact size={"3em"} color="#0bbfff" /> Quiz App
            </span>
          </div>
        </SidebarHeader>

        <SidebarContent>
          <Menu iconShape="circle">
            <MenuItem
              icon={<FaTachometerAlt />}
              suffix={<span className="badge red">New</span>}
            >
              <Link to="/admin">Dashboard</Link>
            </MenuItem>
            <MenuItem icon={<FaGem />}>Components</MenuItem>
          </Menu>
          <Menu iconShape="circle">
            <SubMenu
              suffix={<span className="badge yellow">3</span>}
              icon={<MdFeaturedPlayList />}
              title={"Features"}
            >
              <MenuItem>
                <Link to="/admin/manage-user">Quản lý Users</Link>
              </MenuItem>
              <MenuItem>Quản lý Bài Quiz</MenuItem>
              <MenuItem>Quản lý Câu hỏi</MenuItem>
            </SubMenu>
            <SubMenu
              prefix={<span className="badge gray">Favorite</span>}
              icon={<FaHeart />}
            >
              <MenuItem>1</MenuItem>
              <MenuItem>2</MenuItem>
              <MenuItem>3</MenuItem>
            </SubMenu>
            <SubMenu icon={<FaList />}>
              <MenuItem>1 </MenuItem>
              <MenuItem>2 </MenuItem>
              <SubMenu title={`$3`}>
                <MenuItem>3.1 </MenuItem>
                <MenuItem>3.2 </MenuItem>
                <SubMenu title={`$3.3`}>
                  <MenuItem>3.3.1 </MenuItem>
                  <MenuItem>3.3.2 </MenuItem>
                  <MenuItem>3.3.3 </MenuItem>
                </SubMenu>
              </SubMenu>
            </SubMenu>
          </Menu>
        </SidebarContent>

        <SidebarFooter style={{ textAlign: "center" }}>
          <div
            className="sidebar-btn-wrapper"
            style={{
              padding: "20px 24px",
            }}
          >
            <a
              href="https://github.com/azouaoui-med/react-pro-sidebar"
              target="_blank"
              className="sidebar-btn"
              rel="noopener noreferrer"
            >
              <FaGithub />
              <span
                style={{
                  whiteSpace: "nowrap",
                  textOverflow: "ellipsis",
                  overflow: "hidden",
                }}
              >
                ViewSource
              </span>
            </a>
          </div>
        </SidebarFooter>
      </ProSidebar>
    </div>
  );
};

export default SideBar;
