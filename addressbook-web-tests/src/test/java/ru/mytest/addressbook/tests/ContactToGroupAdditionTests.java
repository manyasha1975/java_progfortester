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
  }

  @Test
  public void testContactToGroupAddition() throws Exception {
    app.goTo().homePage();
    app.contact().chooseAllGroup();
    ContactData addedContact = app.db().contacts().iterator().next();
    System.out.println("1. " + addedContact.getGroups());
    GroupData chosenGroup = app.db().groups().iterator().next();
    System.out.println("2. " + chosenGroup);
    Contacts contactsInAGroupAfter = null;
    Contacts contactsInAGroupBefore = null;
//    if (!app.contact().isContactInAGroup(addedContact.inGroup(chosenGroup))) {
    if (!app.contact().isContactInAGroup(addedContact, chosenGroup)) {
      try {
        contactsInAGroupBefore = chosenGroup.getContacts();
      } catch (NoSuchElementException e) {
      }
      app.contact().addToGroup(addedContact.inGroup(chosenGroup));
      System.out.println("5. " + addedContact.getGroups());
      contactsInAGroupAfter = chosenGroup.getContacts();
    }
    //assertThat(contactsInAGroupAfter, equalTo(contactsInAGroupBefore.withAdded(addedContact)));
  }
}
