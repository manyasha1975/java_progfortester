package ru.mytest.addressbook.tests;

import org.testng.annotations.Test;
import ru.mytest.addressbook.model.GroupData;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {
    app.gotoGroupPage();
    app.initGroupCreation();
    app.fillGroupForm(new GroupData("Group3", "Test group3", "Test group3_1"));
    app.submitGroupCreation();
    app.returnToGroupPage();
  }

}
