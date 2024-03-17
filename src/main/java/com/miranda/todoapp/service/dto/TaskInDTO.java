package com.miranda.todoapp.service.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TaskInDTO {

	

	private String title;

	private String description;

	private LocalDateTime eta;

}
