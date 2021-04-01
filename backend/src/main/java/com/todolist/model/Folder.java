package com.todolist.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Folder {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idFolder;
	
	@Column
	private String name;
	
	@OneToMany(
			mappedBy = "folder",
			cascade = CascadeType.ALL,
			orphanRemoval = true
	)
	private List<Task> tasks;

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

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks.clear();
		this.tasks.addAll(tasks);
	}
}
