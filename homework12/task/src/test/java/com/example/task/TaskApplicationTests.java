package com.example.task;

import com.example.task.exceptions.AccountNotFoundException;
import com.example.task.model.Task;
import com.example.task.repository.TaskRepository;
import com.example.task.service.TasksService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class TaskApplicationTests {

	@Test
	void contextLoads() {
	}

	/**
	 * Заглушка
	 */
	@Mock
	public TaskRepository taskRepository;

	/**
	 * Хотим тестировать
	 */
	@InjectMocks
	public TasksService tasksService;

	@Test
	public void testTaskId(){
		//предпос
		Task task = new Task();
		task.setId(1L);
		given(taskRepository.findById(task.getId())).willReturn(Optional.of(task));
		//вызов
		tasksService.findById(1L);
		//проверка
		verify(taskRepository).findById(1L);
	}

	/**
	 * Проверка ошибок
	 */
//	@Test
//	public void moneyTransferDestinationAccountNotFoundFlow() {
//		Task task = new Task();
//		task.setId(1L);
//
//		given(taskRepository.findById(1L))
//				.willReturn(Optional.of(task));
//
//		assertThrows(
//				AccountNotFoundException.class,
//				() -> tasksService.findById(1L)
//		);
//	}

}
