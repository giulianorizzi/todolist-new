package com.todolist.dto;

import java.io.Serializable;

public class TaskFullDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		
	private Integer idTask;
	private String name;
	private Boolean completed;
	private FolderDTO folder;

	public TaskFullDTO() {
		super();
	}

	public TaskFullDTO(Integer idTask, String name, Boolean completed, FolderDTO folder) {
		super();
		this.idTask = idTask;
		this.name = name;
		this.completed = completed;
		this.folder = folder;
	}
	
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
	public FolderDTO getFolder() {
		return folder;
	}
	public void setFolder(FolderDTO folder) {
		this.folder = folder;
	}
}
