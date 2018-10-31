package ru.mytest.addressbook.tests;

import org.testng.annotations.Test;
import ru.mytest.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    app.getNavigationHelper().gotoHomePage();
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Fedor", "Ivanov", "Vanilla", "Dev", null, "Ekaterinburg", "+79192347658", "fedor@gmail.com", "[none]"), true);
    }
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("Fedor", "Petrov", "Fedora_mod", "Tester_mod", "Test company_mod", "Ekaterinburg_mod", "+79192347685", "fedor_mod@gmail.com", null), false);
    app.getContactHelper().submitContactModification();
    app.getNavigationHelper().gotoHomePage();
  }
}
