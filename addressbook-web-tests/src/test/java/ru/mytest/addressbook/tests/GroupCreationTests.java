package ru.mytest.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.mytest.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {
    app.getNavigationHelper().gotoGroupPage();
    List<GroupData> before = app.getGroupHelper().getGroupList();
    GroupData group = new GroupData("Group_3", null, null);
    app.getGroupHelper().createGroup(group);
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size() + 1);

    int max =0;
    for (GroupData g : after) {
      if (g.getGrid() > max) {
        max = g.getGrid();
      }
    }
    group.setGrid(max);
    before.add(group);
    Assert.assertEquals(new HashSet<>(before), new HashSet<>(after));
    }

}
