package com.example.task.controller;

import com.example.task.model.Task;
import com.example.task.model.TaskStatus;
import com.example.task.service.FileGateway;
import com.example.task.service.TasksService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tasks")
@AllArgsConstructor
public class TaskController {

    private final TasksService service;

    private final FileGateway fileGateway;

//    @GetMapping("/tasks")
//    public String getHomePage(){
//        return "home";
//    }

    /**
     * Добавление задачи
     * @param task
     * @return
     */
    @PostMapping
    public ResponseEntity<Task> addTask(@RequestBody Task task){
        fileGateway.writeToFile("Tasks.txt", task.toString());
        return service.addTask(task);
    }

    /**
     * Просмотр задач по статусу как вводить статус http://example.com/person/42/contacts
     * @param status "завершена", "в процессе", "не начата"
     * @return
     */
    @GetMapping("/status/{status}")
    public Optional<Task> getTasksByStatus(@PathVariable TaskStatus status){
        return service.findByTaskStatus(status);
    }

    /**
     * Метод изменения статуса задачи
     * @param id персональный идентификатор задачи
     * @param task задача
     * @return
     */
    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTaskByStatus(@PathVariable Long id, @RequestBody Task task)
    {
        return service.updateById(id, task);
    }

    /**
     * Удаление задачи
     * @param id персональный идентификатор задачи
     */
    @DeleteMapping("/{id}")
    public void deleteTaskBuId(@PathVariable Long id){
//        service.publishComment(id);
        service.deleteById(id);
    }

    @GetMapping
    public ResponseEntity<List<Task>>getAllTasks(){
        return ResponseEntity.ok().body(service.findAll().getBody());
    }
}
