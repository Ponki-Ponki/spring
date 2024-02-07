package homework5.dto;

import homework5.task.TaskStatus;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class TransferRequest {
    private Long id;
    private TaskStatus taskStatus;
    private String textTask;
    private LocalDateTime dateCreation;
}
