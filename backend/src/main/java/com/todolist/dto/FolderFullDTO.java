package com.todolist.dto;

import java.io.Serializable;
import java.util.List;

public class FolderFullDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer idFolder;
	private String name;
	private List<TaskDTO> tasks;
	
	public FolderFullDTO() {
		super();
	}
	
	public FolderFullDTO(Integer idFolder, String name, List<TaskDTO> tasks) {
		super();
		this.idFolder = idFolder;
		this.name = name;
		this.tasks = tasks;
	}
	
	public Integer getIdFolder() {
		return idFolder;
	}
	public void setIdFolder(Integer id_folder) {
		this.idFolder = id_folder;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<TaskDTO> getTasks() {
		return tasks;
	}
	public void setTasks(List<TaskDTO> tasks) {
		this.tasks = tasks;
	}
}
