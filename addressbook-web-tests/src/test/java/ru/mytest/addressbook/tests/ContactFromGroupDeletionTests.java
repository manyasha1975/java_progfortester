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

public class ContactFromGroupDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.contact().ensurePreconditions();
    app.group().ensurePreconditions();
  }

  @Test
  public void testContactFromGroupDeletion() throws Exception {
    app.goTo().homePage();
    app.contact().chooseAllGroup();
    ContactData deletedContact = app.contact().findContactWithGroup();
    System.out.println("1. " + deletedContact);
    Contacts contacts = app.db().contacts();
    Groups groupsOfContactBefore = contacts.iterator().next()
            .withId(deletedContact.getId()).getGroups();
    System.out.println("2. " + groupsOfContactBefore);
    GroupData chosenGroup = contacts.iterator().next()
            .withId(deletedContact.getId()).getGroups().iterator().next();
    System.out.println("3. " + chosenGroup);
    app.contact().chooseGroupByName(chosenGroup);
    app.contact().deleteFromGroup(deletedContact, chosenGroup);
    Contacts refreshContacts = app.db().contacts();
    Groups groupsOfContactAfter = refreshContacts.iterator().next()
            .withId(deletedContact.getId()).getGroups();
    System.out.println("4. " + groupsOfContactBefore.without(chosenGroup));
    System.out.println("5. " + groupsOfContactAfter);
    assertThat(groupsOfContactAfter, equalTo(groupsOfContactBefore.without(chosenGroup)));
  }
}
