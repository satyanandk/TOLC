package com.asu.tolc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SEQ_DTLS")
public class SequenceEntity {
	@Id 
	@Column(name = "seq_name",length = 10)
	private String seqName;
	@Column(name="seq_val")
	private int seqVal;
	
	public String getSeqName() {
		return seqName;
	}
	public void setSeqName(String seqName) {
		this.seqName = seqName;
	}
	public int getSeqVal() {
		return seqVal;
	}
	public void setSeqVal(int seqVal) {
		this.seqVal = seqVal;
	}
	
	

}
