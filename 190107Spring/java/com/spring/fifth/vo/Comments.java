package com.spring.fifth.vo;

public class Comments {

	private int commentsseq;
	private int boardseq;
	private String id;
	private String comments;
	private String indate;
	private int parentseq;
	private String targetid;

	public Comments(int commentsseq, int boardseq, String id, String comments, String indate, int parentseq,
			String targetid) {
		super();
		this.commentsseq = commentsseq;
		this.boardseq = boardseq;
		this.id = id;
		this.comments = comments;
		this.indate = indate;
		this.parentseq = parentseq;
		this.targetid = targetid;
	}

	public Comments() {
		super();
	}

	public int getCommentsseq() {
		return commentsseq;
	}

	public void setCommentsseq(int commentsseq) {
		this.commentsseq = commentsseq;
	}

	public int getBoardseq() {
		return boardseq;
	}

	public void setBoardseq(int boardseq) {
		this.boardseq = boardseq;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getIndate() {
		return indate;
	}

	public void setIndate(String indate) {
		this.indate = indate;
	}

	public int getParentseq() {
		return parentseq;
	}

	public void setParentseq(int parentseq) {
		this.parentseq = parentseq;
	}

	public String getTargetid() {
		return targetid;
	}

	public void setTargetid(String targetid) {
		this.targetid = targetid;
	}

	@Override
	public String toString() {
		return "Comments [commentsseq=" + commentsseq + ", boardseq=" + boardseq + ", id=" + id + ", comments="
				+ comments + ", indate=" + indate + ", parentseq=" + parentseq + ", targetid=" + targetid + "]";
	}

}
