package homework5.task;

import lombok.Data;
import lombok.NonNull;

import java.time.LocalDateTime;
@Data
public class Task {

    Long id;
    @NonNull String textTask;
    TaskStatus taskStatus;
    LocalDateTime dateCreate;

}
