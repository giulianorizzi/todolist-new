package com.todolist.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Task {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idTask;
	
	@Column
	private String name;
	
	@Column
	private Boolean completed;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idFolder")
	private Folder folder;
	
	// Getters y Setters
	public Integer getIdTask() {
		return idTask;
	}

	public void setIdTask(Integer idTask) {
		this.idTask = idTask;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getCompleted() {
		return completed;
	}

	public void setCompleted(Boolean completed) {
		this.completed = completed;
	}
	
	public Folder getFolder() {
		return folder;
	}

	public void setFolder(Folder folder) {
		this.folder = folder;
	}
}
