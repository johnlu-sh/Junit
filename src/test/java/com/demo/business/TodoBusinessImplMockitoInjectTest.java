package com.demo.business;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.demo.data.api.TodoService;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TodoBusinessImplMockitoInjectTest {
  @Mock
  TodoService todoService;

  @InjectMocks
  TodoBusinessImpl todoBusinessImpl;

  @Captor
  ArgumentCaptor<String> stringArgumentCaptor;

  @Test
  public void testRetrieveTodosRelatedToSpring() throws Exception {
    List<String> allTodos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
    when(todoService.retrieveTodos("luyq")).thenReturn(allTodos);
    List<String> todos = todoBusinessImpl.retrieveTodosRelatedToSpring("luyq");
    assertEquals(2, todos.size());
  }

  @Test
  public void testRetrieveTodosRelatedToSpring_BDD() {
    List<String> allTodos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
    given(todoService.retrieveTodos("luyq")).willReturn(allTodos);
    List<String> todos = todoBusinessImpl.retrieveTodosRelatedToSpring("luyq");
    assertThat(todos.size(), is(2));
  }

  @Test
  public void testDeleteTodosNotRelatedToSpring() {
    List<String> allTodos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
    when(todoService.retrieveTodos("luyq")).thenReturn(allTodos);
    todoBusinessImpl.deleteTodosNotRelatedToSpring("luyq");
    verify(todoService).deleteTodo("Learn to Dance");
    verify(todoService, never()).deleteTodo("Learn Spring");
    verify(todoService, never()).deleteTodo("Learn Spring MVC");
    verify(todoService, times(1)).deleteTodo("Learn to Dance");
  }

  @Test
  public void captureArgument() {
    List<String> allTodos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
    when(todoService.retrieveTodos("Ranga")).thenReturn(allTodos);
    todoBusinessImpl.deleteTodosNotRelatedToSpring("Ranga");
    verify(todoService).deleteTodo(stringArgumentCaptor.capture());
    assertEquals("Learn to Dance", stringArgumentCaptor.getValue());
  }
}
