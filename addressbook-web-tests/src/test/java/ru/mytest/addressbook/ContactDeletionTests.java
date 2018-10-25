package ru.mytest.addressbook;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class ContactDeletionTests extends TestBase {

  @Test
  public void testContactDeletion() throws Exception {
    gotoHomePage();
    /*selectContact();*/
    selectGroup();
    acceptNextAlert = true;
    deleteSelectedContacts();
    assertTrue(closeAlertAndGetItsText().matches("^Delete 1 addresses[\\s\\S]$"));
    gotoHomePage();
  }

 }
