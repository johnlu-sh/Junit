package com.demo.business;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.demo.data.api.TodoService;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.mockito.ArgumentCaptor;


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

  @Test
  public void testRetrieveTodosRelatedToSpring_BDD() {
    List<String> allTodos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
    // given
    given(todoService.retrieveTodos("luyq")).willReturn(allTodos);
    TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);
    // when
    List<String> todos = todoBusinessImpl.retrieveTodosRelatedToSpring("luyq");
    // then
    assertThat(todos.size(), is(2));
  }

  @Test
  public void testDeleteTodosNotRelatedToSpring() {
    List<String> allTodos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
    when(todoService.retrieveTodos("luyq")).thenReturn(allTodos);
    TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);
    todoBusinessImpl.deleteTodosNotRelatedToSpring("luyq");
    verify(todoService).deleteTodo("Learn to Dance");
    verify(todoService, never()).deleteTodo("Learn Spring MVC");
    verify(todoService, never()).deleteTodo("Learn Spring");
    verify(todoService, times(1)).deleteTodo("Learn to Dance"); // atLeastOnce, atLeast
  }

  @Test
  public void captureArgument() {
    ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
    List<String> allTodos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
    when(todoService.retrieveTodos("luyq")).thenReturn(allTodos);
    TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);
    todoBusinessImpl.deleteTodosNotRelatedToSpring("luyq");
    verify(todoService).deleteTodo(argumentCaptor.capture());
    assertEquals("Learn to Dance", argumentCaptor.getValue());
  }
}
