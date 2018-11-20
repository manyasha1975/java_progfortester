package ru.mytest.addressbook.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.mytest.addressbook.model.GroupData;
import ru.mytest.addressbook.model.Groups;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTests extends TestBase {

  @DataProvider
  public Iterator<Object[]> validGroups() {
    List<Object[]> list = new ArrayList<Object[]>();
    list.add(new Object[] {new GroupData().withName("group_1").withHeader("header_1").withFooter("footer_1")});
    list.add(new Object[] {new GroupData().withName("group_2").withHeader("header_2").withFooter("footer_2")});
    list.add(new Object[] {new GroupData().withName("group_3").withHeader("header_3").withFooter("footer_3")});
    return list.iterator();  //Test framework TestNG organizes cycle and give objects from list to test
  }

  @Test(dataProvider = "validGroups")
  public void testGroupCreation(GroupData group) throws Exception {
    app.goTo().groupPage();
    Groups before = app.group().all();
    app.group().create(group);
    assertThat(app.group().count(), equalTo(before.size() + 1));
    Groups after = app.group().all();

    assertThat(after, equalTo(
            before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getGrid()).max().getAsInt()))));
    }

  @Test (enabled = false)
  public void testBadGroupCreation() throws Exception {
    app.goTo().groupPage();
    Groups before = app.group().all();
    app.group().create(new GroupData().withName("Group_3'"));
    assertThat(app.group().count(), equalTo(before.size()));
    Groups after = app.group().all();

    assertThat(after, equalTo(before));
  }

}
