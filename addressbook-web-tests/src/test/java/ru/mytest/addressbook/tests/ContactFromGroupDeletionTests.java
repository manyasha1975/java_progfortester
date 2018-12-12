package ru.mytest.addressbook.tests;

import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.mytest.addressbook.model.ContactData;
import ru.mytest.addressbook.model.Contacts;
import ru.mytest.addressbook.model.GroupData;
import ru.mytest.addressbook.model.Groups;

public class ContactFromGroupDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.contact().ensurePreconditions();
  }

  @Test
  public void testContactFromGroupDeletion() throws Exception {
    app.goTo().homePage();
    app.contact().chooseAllGroup();
    ContactData deletedContact = app.db().contacts().iterator().next();
    GroupData chosenGroup = app.db().groups().iterator().next();
    System.out.println("1. " + chosenGroup);
    Contacts contactsInAGroupAfter = null;
    Contacts contactsInAGroupBefore = null;
    if (!app.contact().isContactInAGroup(deletedContact, chosenGroup)) {
      try {
        contactsInAGroupBefore = chosenGroup.getContacts();
      } catch (NoSuchElementException e) {
      }
      app.contact().addToGroup(deletedContact.inGroup(chosenGroup));
      contactsInAGroupAfter = chosenGroup.getContacts();
    }
    //assertThat(contactsInAGroupAfter, equalTo(contactsInAGroupBefore.withAdded(addedContact)));
  }
}
