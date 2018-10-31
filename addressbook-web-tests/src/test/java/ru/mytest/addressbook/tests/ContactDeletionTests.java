package ru.mytest.addressbook.tests;

import org.testng.annotations.Test;
import ru.mytest.addressbook.model.ContactData;

public class ContactDeletionTests extends TestBase {

  @Test
  public void testContactDeletion() throws Exception {
    app.getNavigationHelper().gotoHomePage();
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Fedor", "Ivanov", "Vanilla", "Dev", null, "Ekaterinburg", "+79192347658", "fedor@gmail.com", "[none]"), true);
    }
    app.getContactHelper().selectContact();
    app.acceptNextAlert = true;
    app.getContactHelper().deleteSelectedContacts();
    app.getContactHelper().closeDialogWindow();
    app.getNavigationHelper().gotoHomePage();
  }

}
