package homework5.task;

import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
@Data
public class Task {

    @Id
    Long id;
    @NonNull String description;
    TaskStatus taskStatus;
    LocalDateTime dateCreate;

}
