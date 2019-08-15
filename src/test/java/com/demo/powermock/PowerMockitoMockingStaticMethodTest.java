package com.demo.powermock;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.verifyStatic;

import java.util.Arrays;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({UtilityClass.class})
public class PowerMockitoMockingStaticMethodTest {

  @Mock
  Dependency dependency;

  @InjectMocks
  SystemUnderTest systemUnderTest;

  @Test
  public void powerMockito_MockingAStaticMethodCall() {
    when(dependency.retrieveAllStatus()).thenReturn(Arrays.asList(1, 2, 3));
    mockStatic(UtilityClass.class);
    when(UtilityClass.staticMethod(anyLong())).thenReturn(150);
    assertEquals(150, systemUnderTest.methodCallingAStaticMethod());
  }
}
