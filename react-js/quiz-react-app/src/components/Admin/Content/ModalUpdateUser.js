import { useEffect, useState } from "react";
import { Button, Modal } from "react-bootstrap";
import { toast } from "react-toastify";
import { putUpdateUser } from "../../../services/apiService";
import _ from "lodash";
import CommonUtils from "../../../utils/CommonUtils";

function ModalUpdateUser(props) {
  const {
    show,
    setShow,
    dataUpdateUser,
    // fetchListUser,
    resetUpdate,
    fetchListUserPaging,
    currentPage,
  } = props;

  const [id, setId] = useState("");
  const [email, setEmail] = useState("");
  const [username, setUsername] = useState("");
  const [role, setRole] = useState("");
  const [image, setImage] = useState("");

  useEffect(() => {
    if (!_.isEmpty(dataUpdateUser) && dataUpdateUser.id) {
      setId(dataUpdateUser.id);
      setEmail(dataUpdateUser.email);
      setUsername(dataUpdateUser.username);
      setRole(dataUpdateUser.role);
      setImage(dataUpdateUser.userImage);
    }
  }, [dataUpdateUser, resetUpdate]);

  const handleClose = () => {
    setShow(false);
    setId("");
    setEmail("");
    setUsername("");
    setRole("");
    setImage("");
  };

  const handleSubmitUpdateUser = async () => {
    if (_.isEmpty(username) || _.isEmpty(role)) {
      toast.error("Vui lòng nhập đầy đủ thông tin");
      return;
    } else if (
      CommonUtils.isContainSpace(username) ||
      CommonUtils.isContainSpace(role)
    ) {
      toast.error("Vui lòng nhập đúng thông tin");
      return;
    } else if (id === undefined || username === "") {
      toast.error("Không tìm thấy id người dùng");
      return;
    }

    let res = await putUpdateUser(id, username, role, image);
    console.log(res);

    if (res && res.EC === 0) {
      toast.success(res.EM);
      handleClose();
      // fetchListUser();
      fetchListUserPaging(currentPage);
    }
    if (res && res.EC !== 0) {
      toast.error(res.data.EM);
    }
  };

  return (
    <>
      <Modal show={show} onHide={handleClose} size="xl" backdrop="static">
        <Modal.Header closeButton>
          <Modal.Title>Update user</Modal.Title>
        </Modal.Header>
        <Modal.Body>
          <form className="row g-3">
            <div className="col-md-6">
              <label className="form-label">Email</label>
              <input
                type="email"
                className="form-control"
                value={email}
                disabled
                onChange={(e) => setEmail(e.target.value)}
              />
            </div>
            <div className="col-md-6">
              <label className="form-label">Username</label>
              <input
                type="text"
                className="form-control"
                value={username}
                onChange={(e) => setUsername(e.target.value)}
              />
            </div>
            <div className="col-md-6">
              <label className="form-label">Role</label>
              <select
                className="form-select"
                value={role}
                onChange={(e) => setRole(e.target.value)}
              >
                <option selected value={""}>
                  Choose...
                </option>
                <option value={"USER"}>USER</option>
                <option value={"ADMIN"}>ADMIN</option>
              </select>
            </div>
            <div className="col-md-12">
              <label className="form-label">Upload File Image</label>
              <input
                type="file"
                className="form-control"
                value={image}
                onChange={(e) => setImage(e.target.value)}
              />
            </div>
          </form>
        </Modal.Body>
        <Modal.Footer>
          <Button variant="secondary" onClick={handleClose}>
            Close
          </Button>
          <Button variant="primary" onClick={handleSubmitUpdateUser}>
            Update
          </Button>
        </Modal.Footer>
      </Modal>
    </>
  );
}

export default ModalUpdateUser;
