package com.todolist.dto;

import java.io.Serializable;
import java.util.List;

public class FolderDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer idFolder;
	private String name;
	
	public FolderDTO() {
		super();
	}
	
	public FolderDTO(Integer idFolder, String name, List<TaskDTO> tasks) {
		super();
		this.idFolder = idFolder;
		this.name = name;
	}
	
	public Integer getIdFolder() {
		return idFolder;
	}
	public void setIdFolder(Integer idFolder) {
		this.idFolder = idFolder;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
