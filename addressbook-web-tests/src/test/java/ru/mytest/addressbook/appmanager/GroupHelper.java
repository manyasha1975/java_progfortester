package ru.mytest.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.mytest.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

  private void selectGroupById(int grid) {
    driver.findElement(By.cssSelector("input[value='" + grid + "']")).click();
  }

  public void initGroupModification() {
    click(By.name("edit"));
  }

  public void submitGroupModification() {
    click(By.name("update"));
  }

  public void create(GroupData groupData) {
    initGroupCreation();
    fillGroupForm(groupData);
    submitGroupCreation();
    returnToGroupPage();
  }

  public void modify(GroupData group) {
    selectGroupById(group.getGrid());
    initGroupModification();
    fillGroupForm(group);
    submitGroupModification();
    returnToGroupPage();
  }

  public void delete(GroupData group) {
    selectGroupById(group.getGrid());
    deleteSelectedGroups();
    returnToGroupPage();
  }

  public boolean isThereAGroup() {
    return isElementPresent(By.name("selected[]"));
  }

  public int getGroupCount() {
    return driver.findElements(By.name("selected[]")).size();
  }

  public Set<GroupData> all() {
    Set<GroupData> groups = new HashSet<>();
    List<WebElement> elements = driver.findElements(By.cssSelector("span.group"));
    for (WebElement element : elements) {
      String name = element.getText();
      int grid = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      groups.add(new GroupData().withId(grid).withName(name));
    }
    return groups;
  }

}
