package com.todolist.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todolist.dao.TaskDAO;
import com.todolist.model.Task;

@Service
public class TaskService {
	@Autowired
	private TaskDAO taskDAO;
	
	public List<Task> listar() {
		 return taskDAO.findAll();
	}
	 
	public Optional<Task> listarID(int idTask) {
		return taskDAO.findById(idTask);	
	}
		
	public Task insertar(Task task) {
		return taskDAO.save(task);
	}
	 
	public void eliminar(int idTask) {
		taskDAO.deleteById(idTask);
	}
	 
	public Task actualizar(Task task) {
		if(taskDAO.existsById(task.getIdTask())) {
			return taskDAO.save(task);
		} else {
			return null;
		}
	}
}
