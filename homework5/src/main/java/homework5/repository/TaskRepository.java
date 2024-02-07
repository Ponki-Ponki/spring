package homework5.repository;

import homework5.task.Task;
import homework5.task.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    //@Query("SELECT * FROM tasks WHERE taskStatus = :status")
    List<Task> findByStatus(TaskStatus status);
}