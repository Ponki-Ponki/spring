package homework5.services;

import homework5.repository.TaskRepository;
import homework5.task.Task;
import homework5.task.TaskStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskService {
    TaskRepository repository;

    public Task addTask(Task task){
        task.setTaskStatus(TaskStatus.NOT_STARTED);
        task.setDateCreate(LocalDateTime.now());
        repository.save(task);
        return task;
    }

    public List<Task> getAllTask(){
        return repository.findAll();
    }

    public List<Task> getTaskByStatus(TaskStatus status){
        return repository.findByStatus(status);
    }

}
