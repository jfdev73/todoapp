package com.miranda.todoapp.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.miranda.todoapp.persistence.entity.Task;
import com.miranda.todoapp.persistence.entity.TaskStatus;

public interface TaskRepository extends JpaRepository<Task, Long> {
	
	 List<Task> findAllByTaskStatus(TaskStatus taskStatus);
	 
	 @Modifying
	 @Query(value = "UPDATE TASK SET FINISHED=true WHERE ID=:id", nativeQuery = true)
	 void markTaskAsFinished(@Param("id") Long id);

}
