package model.bo;

import model.dao.NguoiDungDAO;

public class NguoiDungBO {
	NguoiDungDAO nguoiDungDAO = new NguoiDungDAO();

	public boolean checkLogin(String tenDangNhap, String matKhau) {
		return nguoiDungDAO.checkLogin(tenDangNhap, matKhau);
	}

}
