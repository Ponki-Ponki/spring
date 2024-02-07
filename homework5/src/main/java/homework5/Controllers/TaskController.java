package homework5.Controllers;

import homework5.task.Task;
import homework5.task.TaskStatus;
import org.springframework.web.bind.annotation.*;

public class TaskController {
    @PostMapping
    public Task addTask(@RequestBody Task task){

    }
    @GetMapping
    public List<Task> getAllTasks(){
    }

    @GetMapping("/status/{status}")
    public List<Task> getTasksByStatus(@PathVariable TaskStatus status){}

    @PutMapping("/{id}")
    public Task updateTaskStatus(@PathVariable Long id, @RequestBody Task task){}

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id){}
}
