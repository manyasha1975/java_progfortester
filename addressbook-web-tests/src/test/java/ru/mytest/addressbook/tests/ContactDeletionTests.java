package ru.mytest.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {

  @Test
  public void testContactDeletion() throws Exception {
    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().selectContact();
    app.acceptNextAlert = true;
    app.getContactHelper().deleteSelectedContacts();
    app.getContactHelper().closeDialogWindow();
    app.getNavigationHelper().gotoHomePage();
  }

}
