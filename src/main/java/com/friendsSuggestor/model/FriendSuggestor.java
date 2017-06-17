package com.friendsSuggestor.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "friend_suggest")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class FriendSuggestor {
	@Id
	@GeneratedValue
	@Column(name = "id")
	public Integer id;
	@Column(name = "name")
	public String name;
	@Column(name = "path")
	public String filePath;
	@Column(name = "Identification")
	public String identification;
	@Column(name = "face_id")
	public String faceId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getIdentification() {
		return identification;
	}

	public void setIdentification(String identification) {
		this.identification = identification;
	}

	public String getFaceId() {
		return faceId;
	}

	public void setFaceId(String faceId) {
		this.faceId = faceId;
	}

}
