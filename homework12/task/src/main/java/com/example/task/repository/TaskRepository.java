package com.example.task.repository;

import com.example.task.model.Task;
import com.example.task.model.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Long> {

    /**
     * Поиск и получение задачи по заданному статусу
     * @param status
     * @return
     */
    Optional<Task> findByTaskStatus(TaskStatus status);

}