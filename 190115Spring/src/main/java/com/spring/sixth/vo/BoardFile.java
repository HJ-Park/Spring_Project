package com.spring.sixth.vo;

public class BoardFile {
	private String fileseq;
	private String boardseq;
	private String orgname;
	private String savname;
	private String indate;
	public BoardFile() {
		super();
	}
	public BoardFile(String fileseq, String boardseq, String orgname, String savname, String indate) {
		super();
		this.fileseq = fileseq;
		this.boardseq = boardseq;
		this.orgname = orgname;
		this.savname = savname;
		this.indate = indate;
	}
	public String getFileseq() {
		return fileseq;
	}
	public void setFileseq(String fileseq) {
		this.fileseq = fileseq;
	}
	public String getBoardseq() {
		return boardseq;
	}
	public void setBoardseq(String boardseq) {
		this.boardseq = boardseq;
	}
	public String getOrgname() {
		return orgname;
	}
	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}
	public String getSavname() {
		return savname;
	}
	public void setSavname(String savname) {
		this.savname = savname;
	}
	public String getIndate() {
		return indate;
	}
	public void setIndate(String indate) {
		this.indate = indate;
	}
	@Override
	public String toString() {
		return "BoardFile [fileseq=" + fileseq + ", boardseq=" + boardseq + ", orgname=" + orgname + ", savname="
				+ savname + ", indate=" + indate + "]";
	}
	
}
