package com.atmecs.TechTonics.pojos;

import java.util.Date;

public class TechTalk {
	private java.sql.Date talkDate;
	private String talkTitle;
	private String talkDescription;
	private Employee talkPresenter;
	public TechTalk(java.sql.Date talkDate, String talkTitle, String talkDescription, Employee talkPresenter) {
		super();
		this.talkDate = talkDate;
		this.talkTitle = talkTitle;
		this.talkDescription = talkDescription;
		this.talkPresenter = talkPresenter;
	}
	public java.sql.Date getTalkDate() {
		return talkDate;
	}
	public void setTalkDate(java.sql.Date talkDate) {
		this.talkDate = talkDate;
	}
	public String getTalkTitle() {
		return talkTitle;
	}
	public void setTalkTitle(String talkTitle) {
		this.talkTitle = talkTitle;
	}
	public String getTalkDescription() {
		return talkDescription;
	}
	public void setTalkDescription(String talkDescription) {
		this.talkDescription = talkDescription;
	}
	public Employee getTalkPresenter() {
		return talkPresenter;
	}
	public void setTalkPresenter(Employee talkPresenter) {
		this.talkPresenter = talkPresenter;
	}
	@Override
	public String toString() {
		return "TechTalk [talkDate=" + talkDate + ", talkTitle=" + talkTitle + ", talkDescription=" + talkDescription
				+ ", talkPresenter=" + talkPresenter + "]";
	}
	
}
