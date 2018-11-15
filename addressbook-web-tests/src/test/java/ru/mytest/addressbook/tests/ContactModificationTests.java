package ru.mytest.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.mytest.addressbook.model.ContactData;

import java.util.Set;

public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData().withFirstName("Fedor").withLastName("Ivanov").withNickName("Vanilla").withTitle("Dev")
              .withAddress("Ekaterinburg").withMobile("+79192347652").withEmail("fedor@gmail.com").withGroup("Group6"), true);
    }
  }

  @Test
  public void testContactModification() {
    Set<ContactData> before = app.contact().all();
    ContactData modifiedContact = before.iterator().next(); //contact is chosen by random method
    ContactData contact = new ContactData().withId(modifiedContact.getId()).withFirstName("Fedor_2").withLastName("Petrov").withNickName("Fedora_mod").withTitle("Tester_mod").
            withCompany("Test company_mod").withAddress("Ekaterinburg_mod").withMobile("+79192347685").withEmail("fedor_mod@gmail.com");
    app.contact().modify(contact);
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size());

    before.remove(modifiedContact);
    before.add(contact);
    Assert.assertEquals(before, after);
  }


}
