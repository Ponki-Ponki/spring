package homework5.services;

import homework5.exception.TaskNotFoundException;
import homework5.repository.TaskRepository;
import homework5.task.Task;
import homework5.task.TaskStatus;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class TaskService {
    private final TaskRepository repository;

    public Task addTask(Task task){
        task.setStatus(TaskStatus.NOT_STARTED);
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

    public Task updateTask(Long id,Task task){
        Task tempTask = repository.findById(id).orElseThrow(() -> new TaskNotFoundException("Not found task!") );
        tempTask.setDescription(task.getDescription());
        tempTask.setStatus(task.getStatus());
        return repository.save(tempTask);
    }

    public void deleteTask(Long id){
        repository.deleteById(id);
    }
}
