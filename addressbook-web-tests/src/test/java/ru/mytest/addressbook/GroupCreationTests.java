package ru.mytest.addressbook;

import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {
    gotoGroupPage();
    initGroupCreation();
    fillGroupForm(new GroupData("Group3", "Test group3", "Test group3_1"));
    submitAction();
    returnToGroupPage();
  }

}
