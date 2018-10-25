package ru.mytest.addressbook.tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class ContactDeletionTests extends TestBase {

  @Test
  public void testContactDeletion() throws Exception {
    app.gotoHomePage();
    /*selectContact();*/
    app.selectGroup();
    app.acceptNextAlert = true;
    app.deleteSelectedContacts();
    assertTrue(app.closeAlertAndGetItsText().matches("^Delete 1 addresses[\\s\\S]$"));
    app.gotoHomePage();
  }

 }
