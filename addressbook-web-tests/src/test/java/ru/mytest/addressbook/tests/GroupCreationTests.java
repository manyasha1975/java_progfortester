package ru.mytest.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.mytest.addressbook.model.GroupData;

import java.util.Set;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {
    app.goTo().groupPage();
    Set<GroupData> before = app.group().all();
    GroupData group = new GroupData().withName("Group_3");
    app.group().create(group);
    Set<GroupData> after = app.group().all();
    Assert.assertEquals(after.size(), before.size() + 1);

    group.withId(after.stream().mapToInt((g) -> g.getGrid()).max().getAsInt());
    before.add(group);
    Assert.assertEquals(before, after);
    }

}
