import { useEffect, useState } from "react";
import { getAllUsers, getUserPaging } from "../../../services/apiService";
import ModalCreateUser from "./ModalCreateUser";
import TableUser from "./TableUser";
import ModalUpdateUser from "./ModalUpdateUser";
import ModalViewUser from "./ModalViewUser";
import ModalDeleteUser from "./ModalDeleteUser";
import TableUserPaging from "./TableUserPaging";
import CommonUtils from "../../../utils/CommonUtils";

const ManageUser = () => {
  const [showModalCreateUser, setShowModalCreateUser] = useState(false);
  const [showModalUpdateUser, setShowModalUpdateUser] = useState(false);
  const [showModalViewUser, setShowModalViewUser] = useState(false);
  const [showModalDeleteUser, setShowModalDeleteUser] = useState(false);

  const [listUser, setListUser] = useState([]);

  const [dataUpdateUser, setDataUpdateUser] = useState({});
  const [resetUpdate, setResetUpdate] = useState(false);

  const [dataViewUser, setDataViewUser] = useState({});
  const [resetView, setResetView] = useState(false);

  const [dataDeleteUser, setDataDeleteUser] = useState({});
  const [resetDelete, setResetDelete] = useState(false);

  const [pageCount, setPageCount] = useState(0);
  const [currentPage, setCurrentPage] = useState(1);

  useEffect(() => {
    // fetchListUser();
    fetchListUserPaging(currentPage);
  }, []);

  // const fetchListUser = async () => {
  //   try {
  //     const res = await getAllUsers();
  //     console.log(res);
  //     if (res.EC === 0) {
  //       setListUser(res.DT);
  //     }
  //   } catch (error) {
  //     console.error(error);
  //   }
  // };

  const fetchListUserPaging = async (page) => {
    try {
      const res = await getUserPaging(page, CommonUtils.LIMIT_PAGING_USER);
      console.log(res);
      if (res.EC === 0) {
        setListUser(res.DT.users);
        setPageCount(res.DT.totalPages);
      }
    } catch (error) {
      console.error(error);
    }
  };

  const handleClickBtnUpdateUser = (item) => {
    setShowModalUpdateUser(true);
    setDataUpdateUser(item);
    setResetUpdate(!resetUpdate);
  };

  const handleClickBtnViewUser = (item) => {
    setShowModalViewUser(true);
    setDataViewUser(item);
    setResetView(!resetView);
  };

  const handleClickBtnDeleteUser = (item) => {
    setShowModalDeleteUser(true);
    setDataDeleteUser(item);
    setResetDelete(!resetDelete);
  };

  return (
    <div className="manage-use-container">
      <div className="title">Manage user</div>
      <div className="user-content">
        <div>
          <button
            className="btn btn-primary btn-create-user"
            onClick={() => setShowModalCreateUser(true)}
          >
            Create User
          </button>
        </div>
        <div>
          {/* <TableUser
            listUser={listUser}
            handleClickBtnUpdateUser={handleClickBtnUpdateUser}
            handleClickBtnViewUser={handleClickBtnViewUser}
            handleClickBtnDeleteUser={handleClickBtnDeleteUser}
          /> */}

          <TableUserPaging
            listUser={listUser}
            handleClickBtnUpdateUser={handleClickBtnUpdateUser}
            handleClickBtnViewUser={handleClickBtnViewUser}
            handleClickBtnDeleteUser={handleClickBtnDeleteUser}
            fetchListUserPaging={fetchListUserPaging}
            pageCount={pageCount}
            currentPage={currentPage}
            setCurrentPage={setCurrentPage}
          />
        </div>
        <ModalCreateUser
          show={showModalCreateUser}
          setShow={setShowModalCreateUser}
          // fetchListUser={fetchListUser}
          fetchListUserPaging={fetchListUserPaging}
          setCurrentPage={setCurrentPage}
        />

        <ModalUpdateUser
          show={showModalUpdateUser}
          setShow={setShowModalUpdateUser}
          // fetchListUser={fetchListUser}
          fetchListUserPaging={fetchListUserPaging}
          dataUpdateUser={dataUpdateUser}
          resetUpdate={resetUpdate}
          currentPage={currentPage}
        />

        <ModalViewUser
          show={showModalViewUser}
          setShow={setShowModalViewUser}
          dataViewUser={dataViewUser}
          resetView={resetView}
        />

        <ModalDeleteUser
          show={showModalDeleteUser}
          setShow={setShowModalDeleteUser}
          // fetchListUser={fetchListUser}
          fetchListUserPaging={fetchListUserPaging}
          dataDeleteUser={dataDeleteUser}
          resetDelete={resetDelete}
          setCurrentPage={setCurrentPage}
        />
      </div>
    </div>
  );
};

export default ManageUser;
