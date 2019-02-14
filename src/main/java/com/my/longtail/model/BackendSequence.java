package com.my.longtail.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "backend_sequence")
public class BackendSequence {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private long id;
	
	@Column(name = "image_prefix", columnDefinition = "VARCHAR(200)", nullable = true)
	private String imagePrefix;
	
	@Column(name = "sequence_name", columnDefinition = "VARCHAR(200)", nullable = true)
	private String sequenceName;
	
	@Column(name = "backend_sequence", columnDefinition = "INT", nullable = true)
	private int backendSequence;
	
	@Column(name = "modified_date", columnDefinition = "DATE", nullable = true)
	private Date modifiedDate;
	
	public BackendSequence() {}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getImagePrefix() {
		return imagePrefix;
	}

	public void setImagePrefix(String imagePrefix) {
		this.imagePrefix = imagePrefix;
	}

	public String getSequenceName() {
		return sequenceName;
	}

	public void setSequenceName(String sequenceName) {
		this.sequenceName = sequenceName;
	}

	public int getBackendSequence() {
		return backendSequence;
	}

	public void setBackendSequence(int backendSequence) {
		this.backendSequence = backendSequence;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	
}
