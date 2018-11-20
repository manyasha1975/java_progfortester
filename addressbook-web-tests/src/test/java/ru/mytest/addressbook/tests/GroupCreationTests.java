package ru.mytest.addressbook.tests;

import com.thoughtworks.xstream.XStream;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.mytest.addressbook.model.GroupData;
import ru.mytest.addressbook.model.Groups;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTests extends TestBase {

  @DataProvider //with using DataProvider we separate data from test scenario
  public Iterator<Object[]> validGroupsCsv() throws IOException {
    List<Object[]> list = new ArrayList<Object[]>();
    //open file for reading
    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/groups.csv")));
    //BufferedReader allows to read the whole row from file (method readLine)
    String line = reader.readLine();
    while (line != null) {
      String[] split = line.split(";"); //to cut row by ;-separator
      list.add(new Object[] {new GroupData().withName(split[0]).withHeader(split[1]).withFooter(split[2])});
      line = reader.readLine();
    }
    return list.iterator();  //Test framework TestNG organizes cycle and give objects from list to test
  }

  @DataProvider //with using DataProvider we separate data from test scenario
  public Iterator<Object[]> validGroupsXml() throws IOException {
    //open file for reading
    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/groups.xml")));
    //BufferedReader allows to read the whole row from file (method readLine)
    String xml = ""; //create empty row to which we will add all rows from file. It needs for method fromXML (it works with String format)
    String line = reader.readLine();
    while (line != null) {
      xml += line; //add row to xml while get end of file
      line = reader.readLine();
    }
    XStream xStream = new XStream();
    xStream.processAnnotations(GroupData.class);
    List<GroupData> groups = (List<GroupData>) xStream.fromXML(xml); //we set needed type of object to convert result of fromXML method
    return groups.stream().map((g) -> new Object[] {g}).collect(Collectors.toList()).iterator();
    //list -> stream -> map applies to all elements some function (in this case - converts every element to Object[] type) ->
    // -> collect in list by Collectors -> return iterator (to provide next data for test)
  }

  @Test(dataProvider = "validGroupsXml")
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
