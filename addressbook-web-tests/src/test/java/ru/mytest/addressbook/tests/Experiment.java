package ru.mytest.addressbook.tests;

import org.testng.annotations.Test;
import ru.mytest.addressbook.model.ContactData;
import ru.mytest.addressbook.model.Contacts;
import ru.mytest.addressbook.model.GroupData;
import ru.mytest.addressbook.model.Groups;

public class Experiment extends TestBase {

  @Test
  public void testExperiment() {
    ContactData contact = app.db().contacts().iterator().next();
    Groups groups = app.db().groups();
    for (GroupData group: groups) {
      if (!group.getContacts().contains(contact)) {
        System.out.println("1. " + group);
      } else {
        System.out.println("2. " + group);
      }
    }

    for (GroupData group: groups) {
      while (group.getContacts().contains(contact)) {
        System.out.println("3. " + group);
      }
    }
  }
}

