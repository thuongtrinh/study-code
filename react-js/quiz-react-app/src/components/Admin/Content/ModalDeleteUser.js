import _ from "lodash";
import { useEffect, useState } from "react";
import { Button, Modal } from "react-bootstrap";
import { toast } from "react-toastify";
import { deleteUser } from "../../../services/apiService";
import CommonUtils from "../../../utils/CommonUtils";

function ModalDeleteUser(props) {
  const {
    show,
    setShow,
    // fetchListUser,
    fetchListUserPaging,
    dataDeleteUser,
    resetDelete,
    setCurrentPage,
  } = props;
  const [id, setId] = useState("");
  const [email, setEmail] = useState("");

  useEffect(() => {
    if (!_.isEmpty(dataDeleteUser) && dataDeleteUser.id) {
      setId(dataDeleteUser.id);
      setEmail(dataDeleteUser.email);
    }
  }, [dataDeleteUser, resetDelete]);

  const handleClose = () => {
    setId("");
    setEmail("");
    setShow(false);
  };

  const handleSubmitDeleteUser = async () => {
    if (CommonUtils.isBlank(id)) {
      toast.error("Không tìm thấy id người dùng");
      return;
    }

    let res = await deleteUser(id);
    console.log(res);

    if (res && res.EC === 0) {
      toast.success(res.EM);
      handleClose();
      // fetchListUser();
      setCurrentPage(1);
      fetchListUserPaging(1);
    }
    if (res && res.EC !== 0) {
      toast.error(res.data.EM);
    }
  };

  return (
    <>
      <Modal show={show} onHide={handleClose}>
        <Modal.Header closeButton>
          <Modal.Title>Delete User</Modal.Title>
        </Modal.Header>
        <Modal.Body>
          Bạn chắc chắn muốn xóa người dụng:
          <span>
            <b>{" " + email}</b>
          </span>
        </Modal.Body>
        <Modal.Footer>
          <Button variant="secondary" onClick={handleClose}>
            Close
          </Button>
          <Button variant="primary" onClick={handleSubmitDeleteUser}>
            Delete
          </Button>
        </Modal.Footer>
      </Modal>
    </>
  );
}

export default ModalDeleteUser;
