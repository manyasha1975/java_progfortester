package ru.mytest.mantis.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ChangingUserPasswordTests extends TestBase {

  @BeforeMethod
  public void startMailServer() {
    app.mail().start();
  }

  @Test
  public void testChangingUserPassword() {

  }
}
