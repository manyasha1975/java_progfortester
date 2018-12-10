package ru.mytest.addressbook.tests;

import org.testng.annotations.Test;
import ru.mytest.addressbook.model.ContactData;
import ru.mytest.addressbook.model.Contacts;
import ru.mytest.addressbook.model.ContactsInGroup;
import ru.mytest.addressbook.model.Groups;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactToGroupAdditionTests extends TestBase {

  @Test
  public void testContactToGroupAddition() throws Exception {
    Groups groups = app.db().groups();
    Contacts contacts = app.db().contacts();
    ContactsInGroup anyContactsInAnyGroup = app.db().anyContactsInAnyGroup();
    System.out.println("5. " + anyContactsInAnyGroup);
    app.goTo().homePage();
    ContactData addedContact = contacts.iterator().next();
    if (anyContactsInAnyGroup.size() > 0) {
      if (app.contact().isAnyContactInAGroup(addedContact)) {
        ContactsInGroup dbContactsInGroupBefore = app.db().contactsInGroup(addedContact.getGroups().iterator().next().getGrid());
        System.out.println("1. " + dbContactsInGroupBefore);
      } else {
        ContactsInGroup dbContactsInGroupBefore = null;
        System.out.println("2. " + dbContactsInGroupBefore);
      }
    } else {
      ContactsInGroup dbContactsInGroupBefore = null;
      System.out.println("3. " + dbContactsInGroupBefore);
    }

    //if (!app.contact().isContactInAGroup(addedContact)) {
      app.contact().addToGroup(addedContact.inGroup(groups.iterator().next()));
      ContactsInGroup dbContactsInGroupAfter = app.db().contactsInGroup(addedContact.getGroups().iterator().next().getGrid());
    System.out.println("4. " + dbContactsInGroupAfter);
    //  assertThat(dbContactsInGroupAfter, equalTo(dbContactsInGroupBefore.withContact(addedContact)));
    //}
  }
}
