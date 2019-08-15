package com.demo.powermock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.powermock.reflect.Whitebox.invokeMethod;

import java.util.Arrays;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
public class PowerMockitoMockingPrivateMethodTest {

  @Mock
  Dependency dependency;

  @InjectMocks
  SystemUnderTest systemUnderTest;

  @Test
  public void powerMockito_CallingAPrivateMethod() throws Exception {
    when(dependency.retrieveAllStatus()).thenReturn(Arrays.asList(1, 2, 3));
    long value = invokeMethod(systemUnderTest, "privateMethodUnderTest");
    assertEquals(6, value);
  }
}
