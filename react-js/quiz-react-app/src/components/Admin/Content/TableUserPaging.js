import React, { useEffect, useState } from "react";
import ReactPaginate from "react-paginate";

function PaginatedItems({
  itemsPerPage,
  currentPage,
  setCurrentPage,
  fetchListUserPaging,
}) {
  const handlePageClick = (event) => {
    let pageIndex = +event.selected + 1;
    setCurrentPage(pageIndex);
    fetchListUserPaging(pageIndex);
    console.log(`User requested page number ${pageIndex}`);
  };

  return (
    <>
      <ReactPaginate
        nextLabel="Next >"
        onPageChange={handlePageClick}
        pageRangeDisplayed={3}
        marginPagesDisplayed={2}
        pageCount={itemsPerPage}
        previousLabel="< Previous"
        pageClassName="page-item"
        pageLinkClassName="page-link"
        previousClassName="page-item"
        previousLinkClassName="page-link"
        nextClassName="page-item"
        nextLinkClassName="page-link"
        breakLabel="..."
        breakClassName="page-item"
        breakLinkClassName="page-link"
        containerClassName="pagination"
        activeClassName="active"
        renderOnZeroPageCount={null}
        forcePage={currentPage - 1}
      />
    </>
  );
}

const TableUserPaging = (props) => {
  const {
    listUser,
    pageCount,
    fetchListUserPaging,
    currentPage,
    setCurrentPage,
  } = props;

  return (
    <>
      <table className="table table-hover table-bordered">
        <thead>
          <tr>
            <th scope="col">No</th>
            <th scope="col">Username</th>
            <th scope="col">Email</th>
            <th scope="col">Role</th>
            <th scope="col">Action</th>
          </tr>
        </thead>
        <tbody>
          {listUser &&
            listUser.length > 0 &&
            listUser.map((item, index) => {
              return (
                <tr key={`user-${index}`}>
                  <td>{item.id}</td>
                  <td>{item.username}</td>
                  <td>{item.email}</td>
                  <td>{item.role}</td>
                  <td>
                    <button
                      type="button"
                      className="btn btn-secondary"
                      onClick={() => props.handleClickBtnViewUser(item)}
                    >
                      View
                    </button>
                    <button
                      type="button"
                      className="btn btn-warning mx-2"
                      onClick={() => props.handleClickBtnUpdateUser(item)}
                    >
                      Update
                    </button>
                    <button
                      type="button"
                      className="btn btn-danger"
                      onClick={() => props.handleClickBtnDeleteUser(item)}
                    >
                      Delete
                    </button>
                  </td>
                </tr>
              );
            })}
          {(listUser === undefined || (listUser && listUser.length === 0)) && (
            <tr>
              <td colSpan={5} className="text-center">
                <span className="text-danger">Không có dữ liệu</span>
              </td>
            </tr>
          )}
        </tbody>
      </table>
      <div className="d-flex justify-content-end">
        <PaginatedItems
          itemsPerPage={pageCount}
          fetchListUserPaging={fetchListUserPaging}
          currentPage={currentPage}
          setCurrentPage={setCurrentPage}
        />
      </div>
    </>
  );
};

export default TableUserPaging;
