package com.nparo.songr;

import org.junit.Test;

import static com.nparo.songr.RouteController.*;
import static org.junit.Assert.*;

public class RouteControllerTest {
  @Test
  public void testSetCapitalize_SingleWordAllLowerCase() {
    assertEquals(
        "testSetCapitalize_SingleWordAllLowerCase should return: ",
        "WORD",
        setCapitalize("word")
    );
  }

  @Test
  public void testSetCapitalize_SingleWordSomeUpperCase() {
    assertEquals(
        "testSetCapitalize_SingleWordSomeUpperCase should return: ",
        "WORD",
        setCapitalize("woRd")
    );
  }

  @Test
  public void testSetCapitalize_MultipleWordsAllLowerCase() {
    assertEquals(
        "testSetCapitalize_MultipleWordAllLowerCase should return: ",
        "MULTIPLE WORDS CAPITALIZED",
        setCapitalize("multiple words capitalized")
    );
  }

  @Test
  public void testSetCapitalize_MultipleWordsSomeUpperCase() {
    assertEquals(
        "testSetCapitalize_MultipleWordSomeUpperCase should return: ",
        "MULTIPLE WORDS CAPITALIZED",
        setCapitalize("multIplE WoRds cApitaliZED")
    );
  }

  @Test
  public void testSetReverse_SingleWord() {
    assertEquals(
        "testSetReverse_SingleWord should return: ",
        "This",
        setReverse("This")
    );
  }

  @Test
  public void testSetReverse_MultipleWords() {
    assertEquals(
        "testSetReverse_MultipleWords should return: ",
        "great is world This",
        setReverse("This world is great")
    );
  }
}