package form;

import java.util.ArrayList;

import model.bean.Khoa;
import model.bean.SinhVien;

import org.apache.struts.action.ActionForm;

public class DanhSachSinhVienForm extends ActionForm {
	private String maKhoa;
	private ArrayList<Khoa> listKhoa;
	private ArrayList<SinhVien> listSinhVien;

	public String getMaKhoa() {
		return maKhoa;
	}

	public void setMaKhoa(String maKhoa) {
		this.maKhoa = maKhoa;
	}

	public ArrayList<Khoa> getListKhoa() {
		return listKhoa;
	}

	public void setListKhoa(ArrayList<Khoa> listKhoa) {
		this.listKhoa = listKhoa;
	}

	public ArrayList<SinhVien> getListSinhVien() {
		return listSinhVien;
	}

	public void setListSinhVien(ArrayList<SinhVien> listSinhVien) {
		this.listSinhVien = listSinhVien;
	}
}
