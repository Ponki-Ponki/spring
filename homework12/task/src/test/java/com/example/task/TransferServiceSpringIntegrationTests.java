package com.example.task;

import com.example.task.model.Task;
import com.example.task.repository.TaskRepository;
import com.example.task.service.TasksService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@SpringBootTest
public class TransferServiceSpringIntegrationTests {

    @MockBean
    public TaskRepository taskRepository;

    @Autowired
    public TasksService tasksService;

//    @Test
//    public void testTaskId(){
//        //предпос
//        Task task = new Task();
//        task.setId(1L);
//        given(taskRepository.findById(task.getId())).willReturn(Optional.of(task));
//        //вызов
//        tasksService.findById(1L);
//        //проверка
//        verify(taskRepository).findById(1L);
//    }


}
