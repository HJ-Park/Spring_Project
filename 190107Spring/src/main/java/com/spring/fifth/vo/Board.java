package com.spring.fifth.vo;

import java.sql.Date;

public class Board {
	private int boardseq;
	private String id;
	private String boardtitle;
	private String boardcontent;
	private int hitcount;
	private Date indate;

	public Board(int boardseq, String id, String boardtitle, String boardcontent, int hitcount, Date indate) {
		super();
		this.boardseq = boardseq;
		this.id = id;
		this.boardtitle = boardtitle;
		this.boardcontent = boardcontent;
		this.hitcount = hitcount;
		this.indate = indate;
	}

	public Board(String id, String boardtitle, String boardcontent) {
		super();
		this.id = id;
		this.boardtitle = boardtitle;
		this.boardcontent = boardcontent;
	}

	public Board() {
		super();
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

	public String getBoardtitle() {
		return boardtitle;
	}

	public void setBoardtitle(String boardtitle) {
		this.boardtitle = boardtitle;
	}

	public String getBoardcontent() {
		return boardcontent;
	}

	public void setBoardcontent(String boardcontent) {
		this.boardcontent = boardcontent;
	}

	public int getHitcount() {
		return hitcount;
	}

	public void setHitcount(int hitcount) {
		this.hitcount = hitcount;
	}

	public Date getIndate() {
		return indate;
	}

	public void setIndate(Date indate) {
		this.indate = indate;
	}

	@Override
	public String toString() {
		return "Board [boardseq=" + boardseq + ", id=" + id + ", boardtitle=" + boardtitle + ", boardcontent="
				+ boardcontent + ", hitcount=" + hitcount + ", indate=" + indate + "]";
	}

}
