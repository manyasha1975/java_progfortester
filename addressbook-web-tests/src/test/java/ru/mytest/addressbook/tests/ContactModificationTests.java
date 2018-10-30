package ru.mytest.addressbook.tests;

import org.testng.annotations.Test;
import ru.mytest.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("Fedor", "Petrov", "Fedora_mod", "Tester_mod", "Test company_mod", "Ekaterinburg_mod", "+79192347685", "fedor_mod@gmail.com"));
    app.getContactHelper().submitContactModification();
    app.getNavigationHelper().gotoHomePage();
  }
}
