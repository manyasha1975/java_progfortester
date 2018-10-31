package ru.mytest.addressbook.appmanager;

import org.openqa.selenium.By;
import ru.mytest.addressbook.model.GroupData;

public class GroupHelper extends HelperBase {

  public GroupHelper(ApplicationManager app) {
    super(app);
  }

  public void submitGroupCreation() {
    click(By.xpath("//input[@value='Enter information']"));
  }

  public void fillGroupForm(GroupData groupData) {
    type(By.name("group_name"), groupData.getGrname());
    type(By.name("group_header"), groupData.getGrheader());
    type(By.name("group_footer"), groupData.getGrfooter());
  }

  public void initGroupCreation() {
    click(By.name("new"));
  }

  public void returnToGroupPage() {
    click(By.linkText("group page"));
  }

  public void deleteSelectedGroups() {
    click(By.name("delete"));
  }

  public void selectGroup() {
    click(By.name("selected[]"));
  }

  public void initGroupModification() {
    click(By.name("edit"));
  }

  public void submitGroupModification() {
    click(By.name("update"));
  }

  public void createGroup(GroupData groupData) {
    initGroupCreation();
    fillGroupForm(groupData);
    submitGroupCreation();
    returnToGroupPage();
  }

  public boolean isThereAGroup() {
    return isElementPresent(By.name("selected[]"));
  }
}
