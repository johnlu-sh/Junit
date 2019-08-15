package com.demo.mockito;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.arrayContainingInAnyOrder;
import static org.hamcrest.Matchers.arrayWithSize;
import static org.hamcrest.Matchers.emptyOrNullString;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.emptyString;
import static org.hamcrest.Matchers.lessThan;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class HamcrestMatcherTest {
  @Test
  public void basicHamcrestMatchers() {
    List<Integer> scores = Arrays.asList(99, 100, 101, 105);
    assertThat(scores, hasSize(4));
    assertThat(scores, hasItems(100, 101));
    assertThat(scores, everyItem(greaterThan(90)));
    assertThat(scores, everyItem(lessThan(200)));

    // String
    assertThat("", emptyString());
    assertThat(null, emptyOrNullString());

    // Array
    Integer[] marks = {1, 2, 3};
    assertThat(marks, arrayWithSize(3));
    assertThat(marks, arrayContainingInAnyOrder(2, 3, 1));
  }
}
