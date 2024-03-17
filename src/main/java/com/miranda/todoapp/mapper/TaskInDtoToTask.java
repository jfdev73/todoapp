package com.miranda.todoapp.mapper;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.miranda.todoapp.persistence.entity.Task;
import com.miranda.todoapp.persistence.entity.TaskStatus;
import com.miranda.todoapp.service.dto.TaskInDTO;

@Component
public class TaskInDtoToTask implements IMapper<TaskInDTO, Task>{

	@Override
	public Task map(TaskInDTO in) {
		
		Task task = new Task();
		task.setTitle(in.getTitle());
		task.setDescription(in.getDescription());
		task.setEta(in.getEta());
		task.setCreatedDate(LocalDateTime.now());
		task.setFinished(false);
		task.setTaskStatus(TaskStatus.ON_TIME);
		
		return task;
	}

}
