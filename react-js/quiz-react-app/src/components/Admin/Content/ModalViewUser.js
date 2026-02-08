import _ from "lodash";
import { useEffect, useState } from "react";
import { Button, Modal } from "react-bootstrap";

function ModalViewUser(props) {
  const { show, setShow, dataViewUser, resetView } = props;

  const [email, setEmail] = useState("");
  const [username, setUsername] = useState("");
  const [role, setRole] = useState("");
  const [image, setImage] = useState("");

  useEffect(() => {
    if (!_.isEmpty(dataViewUser) && dataViewUser.id) {
      setEmail(dataViewUser.email);
      setUsername(dataViewUser.username);
      setRole(dataViewUser.role);
      setImage(dataViewUser.userImage);
    }
  }, [dataViewUser, resetView]);

  const handleClose = () => {
    setShow(false);
    setEmail("");
    setUsername("");
    setRole("");
    setImage("");
  };

  return (
    <>
      <Modal show={show} onHide={handleClose} size="xl" backdrop="static">
        <Modal.Header closeButton>
          <Modal.Title>Add new user</Modal.Title>
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
                disabled
                onChange={(e) => setUsername(e.target.value)}
              />
            </div>
            <div className="col-md-6">
              <label className="form-label">Role</label>
              <select
                className="form-select"
                value={role}
                disabled
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
                disabled
                onChange={(e) => setImage(e.target.value)}
              />
            </div>
          </form>
        </Modal.Body>
        <Modal.Footer>
          <Button variant="secondary" onClick={handleClose}>
            Close
          </Button>
        </Modal.Footer>
      </Modal>
    </>
  );
}

export default ModalViewUser;
