package ru.mytest.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.mytest.addressbook.model.ContactData;

import java.util.List;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    app.getNavigationHelper().gotoHomePage();
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Fedor", "Ivanov", "Vanilla", "Dev", null, "Ekaterinburg", "+79192347652", "fedor@gmail.com", "Group6"), true);
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().initContactModification(before.size() - 6);
    app.getContactHelper().fillContactForm(new ContactData("Fedor", "Petrov", "Fedora_mod", "Tester_mod", "Test company_mod", "Ekaterinburg_mod", "+79192347685", "fedor_mod@gmail.com", null), false);
    app.getContactHelper().submitContactModification();
    app.getNavigationHelper().gotoHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());
  }
}
