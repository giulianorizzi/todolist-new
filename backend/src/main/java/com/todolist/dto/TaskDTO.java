package com.todolist.dto;

import java.io.Serializable;

public class TaskDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		
	private Integer idTask;
	private String name;
	private Boolean completed;
	
	public TaskDTO() {
		super();
	}

	public TaskDTO(Integer idTask, String name, Boolean completed) {
		super();
		this.idTask = idTask;
		this.name = name;
		this.completed = completed;
	}
	
	public Integer getIdTask() {
		return idTask;
	}
	public void setIdTask(Integer id_task) {
		this.idTask = id_task;
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
}
