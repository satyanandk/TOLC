package com.asu.tolc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "REPLY_DTLS")
public class ReplyEntity {

	@Id
	@GeneratedValue
	@Column(name="reply_no")
	private int replyNo;
	@Column(name="question_no")
	private int questionNo;
	@Column(name="reply", length=1000)
	private String reply;
	@Column(name="replied_by", length=10)
	private String repliedBy;
	public int getReplyNo() {
		return replyNo;
	}
	public void setReplyNo(int replyNo) {
		this.replyNo = replyNo;
	}
	public int getQuestionNo() {
		return questionNo;
	}
	public void setQuestionNo(int questionNo) {
		this.questionNo = questionNo;
	}
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
	public String getRepliedBy() {
		return repliedBy;
	}
	public void setRepliedBy(String repliedBy) {
		this.repliedBy = repliedBy;
	}
	
	

}
