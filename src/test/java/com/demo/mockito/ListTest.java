package com.demo.mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;
import org.junit.Test;

public class ListTest {

  @Test
  public void mockListSize() {
    List list = mock(List.class);
    when(list.size()).thenReturn(10);
    assertEquals(10, list.size());
  }

  @Test
  public void mockListSizeWithMultipleReturnValues() {
    List list = mock(List.class);
    when(list.size()).thenReturn(10).thenReturn(20);
    assertEquals(10, list.size());  // First call
    assertEquals(20, list.size());  // Second call
  }

  @Test
  public void mockListGet() {
    List<String> list = mock(List.class);
    when(list.get(0)).thenReturn("mockito");
    assertEquals("mockito", list.get(0));
    assertNull(list.get(1));
  }

  @Test
  public void mockGetWithAny() {
    List<String> list = mock(List.class);
    when(list.get(anyInt())).thenReturn("mockito");   // Argument Matchers
    assertEquals("mockito", list.get(0));
    assertEquals("mockito", list.get(1));
  }
  
  @Test(expected = RuntimeException.class)
  public void mockGetThrowException() {
    List<String> list = mock(List.class);
    when(list.get(Mockito.anyInt())).thenThrow(new RuntimeException("Something went wrong"));
		list.get(0);
  }
}
