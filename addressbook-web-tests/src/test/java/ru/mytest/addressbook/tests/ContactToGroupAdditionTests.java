package ru.mytest.addressbook.tests;

import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.mytest.addressbook.model.ContactData;
import ru.mytest.addressbook.model.Contacts;
import ru.mytest.addressbook.model.GroupData;
import ru.mytest.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactToGroupAdditionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.contact().ensurePreconditions();
    app.group().ensurePreconditions();
  }

  @Test
  public void testContactToGroupAddition() throws Exception {
    app.goTo().homePage();
    app.contact().chooseAllGroup();
    ContactData addedContact = app.contact().findContactWithoutGroup();
    System.out.println("1. " + addedContact);
    Groups groups = app.db().groups();
    Contacts contacts = app.db().contacts();
    Groups groupsOfContactBefore = contacts.iterator().next()
            .withId(addedContact.getId()).getGroups();
    System.out.println("2. " + groupsOfContactBefore);
    GroupData chosenGroup = app.db().groups().findGroupForContact(addedContact, groups);
    System.out.println("3. " + chosenGroup);
    app.contact().addToGroup(addedContact, chosenGroup);
    System.out.println(chosenGroup);
    Contacts refreshContacts = app.db().contacts();
    Groups groupsOfContactAfter = refreshContacts.iterator().next()
            .withId(addedContact.getId()).getGroups();
    System.out.println("4. " + groupsOfContactBefore.withAdded(chosenGroup));
    System.out.println("5. " + groupsOfContactAfter);
    assertThat(groupsOfContactAfter, equalTo(groupsOfContactBefore.withAdded(chosenGroup)));
  }
}
