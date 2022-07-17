package edu.fa.model;

public class Page {

	private String url;
	private String name;

	public Page() {
		super();
	}

	public Page(String url, String name) {
		super();
		this.url = url;
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Page [url=" + url + ", name=" + name + "]";
	}

}
