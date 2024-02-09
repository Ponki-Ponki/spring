package homework5.Controllers;

import homework5.services.TaskService;
import homework5.task.Task;
import homework5.task.TaskStatus;
import lombok.AllArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
public class TaskController {

    TaskService taskService;


    @PostMapping("/add")
    public String addTask(@RequestBody Task task){
        taskService.addTask(task);
        return "tasks";
    }
    @GetMapping("/tasks")
    public String getAllTasks(Model model){
        List<Task> tasks = taskService.getAllTask();
        model.addAttribute("tasks",tasks);
        return "tasks";
    }


    @GetMapping("/status/{status}")
    public List<Task> getTasksByStatus(@PathVariable TaskStatus status){
        return taskService.getTaskByStatus(status);
    }

    @PutMapping("/{id}")
    public Task updateTaskStatus(@PathVariable Long id, @RequestBody Task task){
        return taskService.updateTask(id, task);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
    }
}
