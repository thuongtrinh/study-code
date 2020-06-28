package form;

import model.bean.Pair;

import org.apache.struts.action.ActionForm;

public class HTML_Tag_1Form extends ActionForm {
	private String textTag;
	private String[] mua = { "Xuan", "Ha", "Thu", "Dong" };
	private String muaHienTai = "Dong";
	private Pair[] pair = { new Pair("3", "P3"), new Pair("4", "P4"), new Pair("5", "P5") };
	private Pair pair2 = new Pair("3", "Viet Nam");

	public Pair getPair2() {
		return pair2;
	}

	public void setPair2(Pair pair2) {
		this.pair2 = pair2;
	}

	public Pair[] getPair() {
		return pair;
	}

	public void setPair(Pair[] pair) {
		this.pair = pair;
	}

	public String getMuaHienTai() {
		return muaHienTai;
	}

	public void setMuaHienTai(String muaHienTai) {
		this.muaHienTai = muaHienTai;
	}

	public String[] getMua() {
		return mua;
	}

	public void setMua(String[] mua) {
		this.mua = mua;
	}

	public String getTextTag() {
		return textTag;
	}

	public void setTextTag(String textTag) {
		this.textTag = textTag;
	}

}
