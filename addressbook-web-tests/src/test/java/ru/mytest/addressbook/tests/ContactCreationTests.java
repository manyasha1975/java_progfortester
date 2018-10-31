package ru.mytest.addressbook.tests;

import org.testng.annotations.Test;
import ru.mytest.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    app.getContactHelper().createContact(new ContactData("Fedor", null, "Fedora", "Tester", null, "Ekaterinburg", "+79192347658", "fedor@gmail.com", "[none]"), true);
    }
}
