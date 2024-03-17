package com.miranda.todoapp.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.miranda.todoapp.exception.ToDoExceptions;
import com.miranda.todoapp.mapper.TaskInDtoToTask;
import com.miranda.todoapp.persistence.entity.Task;
import com.miranda.todoapp.persistence.entity.TaskStatus;
import com.miranda.todoapp.persistence.repository.TaskRepository;
import com.miranda.todoapp.service.dto.TaskInDTO;
import java.util.Optional;
@Service
public class TaskService {
	
	private final TaskRepository repository;
	
	private final TaskInDtoToTask toTask;
	
	public TaskService( TaskRepository repository, TaskInDtoToTask toTask) {
		this.repository = repository;
		this.toTask = toTask;
	}
	
	public Task createTask(TaskInDTO taskInDTO) {
		Task task = toTask.map(taskInDTO);
		return this.repository.save(task);
	}
	
	public List<Task> getTasks(){
		return this.repository.findAll();
	}
	
	public List<Task> findAllByTaskStatus(TaskStatus taskStatus){
		return this.repository.findAllByTaskStatus(taskStatus);
	}
	
	@Transactional
	public void updateTaskAsFinished(Long id) {
		Optional<Task> optionalTask = repository.findById(id);
		if(optionalTask.isEmpty()) {
			throw new ToDoExceptions("Task not found", HttpStatus.NOT_FOUND);
		}
		this.repository.markTaskAsFinished(id);
	}
	
	
	public void deleteById(Long id) {
		Optional<Task> optionalTask = repository.findById(id);
		if(optionalTask.isEmpty()) {
			throw new ToDoExceptions("Task not found", HttpStatus.NOT_FOUND);
		}
		this.repository.deleteById(id);
	}

}
