package com.todolist.rest;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todolist.dto.TaskFullDTO;
import com.todolist.model.Task;
import com.todolist.service.TaskService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("tasks")
public class TaskRest {

	@Autowired
	private TaskService taskService;
	
	@Autowired
    private ModelMapper modelMapper;
	
	@PostMapping("/insertar")
	public TaskFullDTO insertar(@RequestBody TaskFullDTO taskDTO) {
		Task task = convertToFullEntity(taskDTO);
		Task taskCreated = taskService.insertar(task);
        return convertToFullDto(taskCreated);
	}
	
	@GetMapping("/listar")
	public List <TaskFullDTO> listar() {
		List<Task> tasks = taskService.listar();
		return tasks.stream()
				.map(this::convertToFullDto)
				.collect(Collectors.toList());
	}
	
	@DeleteMapping("/eliminar/{id}")
	public void eliminar(@PathVariable("id") int idTask) {
		taskService.eliminar(idTask);
	}
	
	@PutMapping("/actualizar")
	public TaskFullDTO actualizar(@RequestBody TaskFullDTO taskFullDTO) {
		Task task = convertToFullEntity(taskFullDTO);
		Task taskUpdated = taskService.actualizar(task);
		return convertToFullDto(taskUpdated);
	}
	
	private TaskFullDTO convertToFullDto(Task task) {
		TaskFullDTO taskDTO = modelMapper.map(task, TaskFullDTO.class);
	    return taskDTO;
	}
	
	private Task convertToFullEntity(TaskFullDTO taskFullDTO) {
	    Task task = modelMapper.map(taskFullDTO, Task.class);
	    System.out.println("hola" + task);
	    return task;
	}
}
