package com.demo.business;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.demo.data.api.TodoService;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 


public class TodoBusinessImplTest { 
  TodoService todoService;

  @Before
  public void before() throws Exception {
    todoService = mock(TodoService.class);
  }

  @After
  public void after() throws Exception {
  }

  @Test
  public void testRetrieveTodosRelatedToSpring() throws Exception {
    List<String> allTodos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
    when(todoService.retrieveTodos("luyq")).thenReturn(allTodos);
    TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);
    List<String> todos = todoBusinessImpl.retrieveTodosRelatedToSpring("luyq");
    assertEquals(2, todos.size());
  }
} 
