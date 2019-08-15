package com.demo.powermock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.whenNew;


import java.util.ArrayList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({SystemUnderTest.class})
public class PowerMockitoMockingConstructorTest {

  private static final int SOME_DUMMY_SIZE = 100;

  @Mock
  Dependency dependency;

  @InjectMocks
  SystemUnderTest systemUnderTest;

  @Test
  public void powerMockito_MockingAConstructor() throws Exception {
    ArrayList<String> list = mock(ArrayList.class);
    when(list.size()).thenReturn(SOME_DUMMY_SIZE);
    whenNew(ArrayList.class).withAnyArguments().thenReturn(list);
    int size = systemUnderTest.methodUsingAnArrayListConstructor();
    assertEquals(SOME_DUMMY_SIZE, size);
  }
}
